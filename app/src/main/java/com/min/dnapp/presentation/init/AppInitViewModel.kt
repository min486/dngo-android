package com.min.dnapp.presentation.init

import androidx.lifecycle.ViewModel
import com.min.dnapp.presentation.mypage.ProfileImageType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class AppInitViewModel @Inject constructor(

) : ViewModel() {

    // 선택된 프로필 이미지
    private val _selectedImage = MutableStateFlow<ProfileImageType?>(null)
    val selectedImage: StateFlow<ProfileImageType?> = _selectedImage.asStateFlow()

    /**
     * 프로필 이미지 선택
     */
    fun selectImage(image: ProfileImageType) {
        // 선택된 이미지 다시 선택하면 해제
        _selectedImage.value = if (_selectedImage.value == image) null else image
    }
}
