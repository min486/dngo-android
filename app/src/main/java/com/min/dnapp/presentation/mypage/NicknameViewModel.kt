package com.min.dnapp.presentation.mypage

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class NicknameViewModel @Inject constructor(

) : ViewModel() {

    private val _nicknameState = MutableStateFlow(NicknameValidationState())
    val nicknameState: StateFlow<NicknameValidationState> = _nicknameState

    private val MIN_LENGTH = 2
    private val MAX_LENGTH = 10

    // 한글, 영문, 숫자, .(마침표), _(언더만)만 허용
    private val ALLOWED_CHARS_REGEX = Regex("^[가-힣a-zA-Z0-9._]*$")

    /**
     * 사용자의 입력에 따라 닉네임 검사 및 업데이트
     */
    fun onNicknameChange(newInput: String) {

        // 10자 초과 입력 차단
        val finalInput = if (newInput.length > MAX_LENGTH) {
            newInput.substring(0, MAX_LENGTH)
        } else {
            newInput
        }
        Log.d("my", "onNicknameChange finalInput: $finalInput")

        val (isValid, errorMessage) = validateNickname(finalInput)

        _nicknameState.update {
            it.copy(
                currentNickname = finalInput,
                errorMessage = errorMessage,
                isValid = isValid
            )
        }
    }

    private fun validateNickname(nickname: String): Pair<Boolean, String?> {

        // 빈 문자열인 경우
        if (nickname.isEmpty()) {
            return Pair(false, null)
        }

        // 문자 제한 검사
        if (!nickname.matches(ALLOWED_CHARS_REGEX)) {
            return Pair(false, "한글, 영문, 숫자, .(마침표), _(언더바)만 가능합니다")
        }

        // 글자수 제한 검사
        if (nickname.length < MIN_LENGTH) {
            return Pair(false, "2~10자로 입력해주세요")
        }

        // 모든 조건 통과
        return Pair(true, null)
    }
}
