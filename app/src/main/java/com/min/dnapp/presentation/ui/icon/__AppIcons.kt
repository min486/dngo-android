package com.min.dnapp.presentation.ui.icon

import androidx.compose.ui.graphics.vector.ImageVector
import com.min.dnapp.presentation.ui.icon.appicons.Back
import com.min.dnapp.presentation.ui.icon.appicons.Kakao
import kotlin.collections.List as ____KtList

public object AppIcons

private var __AllIcons: ____KtList<ImageVector>? = null

public val AppIcons.AllIcons: ____KtList<ImageVector>
  get() {
    if (__AllIcons != null) {
      return __AllIcons!!
    }
    __AllIcons= listOf(Back, Kakao)
    return __AllIcons!!
  }
