package com.min.dnapp.presentation.common

import com.min.dnapp.R

object EmotionMapper {
    fun getEmotionImageResId(emotionName: String): Int {
        return when (emotionName) {
            "happy" -> R.drawable.emotion_happy
            "love" -> R.drawable.emotion_love
            "surprise" -> R.drawable.emotion_surprise
            "angry" -> R.drawable.emotion_angry
            "feel" -> R.drawable.emotion_feel
            "sad" -> R.drawable.emotion_sad
            "shine" -> R.drawable.emotion_shine
            else -> R.drawable.emotion_happy
        }
    }
}
