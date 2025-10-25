package com.min.dnapp.domain.model

import androidx.annotation.DrawableRes
import com.min.dnapp.R

enum class EmotionType(
    val key: String,
    @DrawableRes val resId: Int
) {
    HAPPY("happy", R.drawable.emotion_happy),
    LOVE("love", R.drawable.emotion_love),
    SURPRISE("surprise", R.drawable.emotion_surprise),
    ANGRY("angry", R.drawable.emotion_angry),
    FEEL("feel", R.drawable.emotion_feel),
    SAD("sad", R.drawable.emotion_sad),
    SHINE("shine", R.drawable.emotion_shine)
}
