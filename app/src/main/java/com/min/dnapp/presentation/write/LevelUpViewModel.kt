package com.min.dnapp.presentation.write

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.min.dnapp.domain.usecase.GetBadgeDialogDataUseCase
import com.min.dnapp.domain.usecase.GetCurrentUserIdUseCase
import com.min.dnapp.domain.usecase.GetUserDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LevelUpViewModel @Inject constructor(
    private val getCurrentUserIdUseCase: GetCurrentUserIdUseCase,
    private val getUserDataUseCase: GetUserDataUseCase,
    private val getBadgeDialogDataUseCase: GetBadgeDialogDataUseCase
) : ViewModel() {

    private val _dialogState = MutableStateFlow<WriteFinishDialogState>(WriteFinishDialogState.Hidden)
    val dialogState: StateFlow<WriteFinishDialogState> = _dialogState.asStateFlow()

    init {
        checkNewBadge()
    }

    /**
     * 새로운 뱃지 달성 여부 체크
     */
    fun checkNewBadge() {
        viewModelScope.launch {

            // 사용자 ID 가져오기
            val uid = try {
                getCurrentUserIdUseCase() ?: throw Exception("사용자 인증 정보 없음")
            } catch (e: Exception) {
                Log.e("write", "사용자 정보 조회 실패", e)
                return@launch
            }

            // 1초 지연 후 모달 표시
            delay(1000)

            val useData = getUserDataUseCase(uid)
            val userStamp = useData.stampCnt

            val newBadge = getBadgeDialogDataUseCase(userStamp)
            _dialogState.value = if (newBadge != null) {
                WriteFinishDialogState.BadgeDialog(newBadge)
            } else {
                WriteFinishDialogState.StampDialog
            }
        }
    }

    fun closeDialog() {
        _dialogState.value = WriteFinishDialogState.Hidden
    }
}
