package com.min.dnapp.presentation.init

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.min.dnapp.domain.usecase.GetInitStatusUseCase
import com.min.dnapp.domain.usecase.SetOnboardingCompletedUseCase
import com.min.dnapp.domain.usecase.SetProfileSetupCompletedUseCase
import com.min.dnapp.domain.usecase.UpdateProfileImageUseCase
import com.min.dnapp.presentation.mypage.ProfileImageType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

enum class InitRoute {
    LOADING,
    ONBOARDING,
    PROFILE_SETUP,
    MAIN
}

data class InitUiState(
    val route: InitRoute = InitRoute.LOADING
)

@HiltViewModel
class AppInitViewModel @Inject constructor(
    getInitStatusUseCase: GetInitStatusUseCase,
    private val setOnboardingCompletedUseCase: SetOnboardingCompletedUseCase,
    private val setProfileSetupCompletedUseCase: SetProfileSetupCompletedUseCase,
    private val updateProfileImageUseCase: UpdateProfileImageUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(InitUiState())
    val uiState: StateFlow<InitUiState> = _uiState.asStateFlow()

    // 선택된 프로필 이미지
    private val _selectedImage = MutableStateFlow<ProfileImageType?>(null)
    val selectedImage: StateFlow<ProfileImageType?> = _selectedImage.asStateFlow()

    // 프로필 저장 상태
    private val _saveImageState = MutableStateFlow<SaveImageState>(SaveImageState.Init)
    val saveImageState: StateFlow<SaveImageState> = _saveImageState.asStateFlow()

    init {
        viewModelScope.launch {
            getInitStatusUseCase().collect { (isOnboardingCompleted, isProfileSetupCompleted) ->
                val nextRoute = when {
                    // 2단계 완료
                    isProfileSetupCompleted -> InitRoute.MAIN
                    // 1단계 완료
                    isOnboardingCompleted -> InitRoute.PROFILE_SETUP
                    // 둘다 완료되지 않음
                    else -> InitRoute.ONBOARDING
                }
                _uiState.update { it.copy(route = nextRoute) }
            }
        }
    }

    /**
     * 온보딩 3개 완료 후 호출
     */
    fun onOnboardingFinished() {
        viewModelScope.launch {
            setOnboardingCompletedUseCase()
        }
    }

    /**
     * 프로필 선택 완료 후 호출
     */
    private fun onProfileSetupFinished() {
        viewModelScope.launch {
            setProfileSetupCompletedUseCase()
        }
    }

    /**
     * 프로필 이미지 선택
     */
    fun selectImage(image: ProfileImageType) {
        // 선택된 이미지 다시 선택하면 해제
        _selectedImage.value = if (_selectedImage.value == image) null else image
    }

    /**
     * 프로필 이미지 저장
     */
    fun saveProfileImage() {
        viewModelScope.launch {
            _selectedImage.value?.let { image ->

                // 로딩 시작
                _saveImageState.value = SaveImageState.Loading

                val result = updateProfileImageUseCase(image.key)

                result.onSuccess {
                    onProfileSetupFinished()
                    _saveImageState.value = SaveImageState.Success
                }.onFailure { exception ->
                    Log.e("init", "saveProfileImage 실패", exception)
                    _saveImageState.value = SaveImageState.Error("이미지 저장 실패")
                }
            }
        }
    }
}
