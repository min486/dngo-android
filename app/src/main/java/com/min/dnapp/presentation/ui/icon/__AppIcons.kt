package com.min.dnapp.presentation.ui.icon

import androidx.compose.ui.graphics.vector.ImageVector
import com.min.dnapp.presentation.ui.icon.appicons.Back
import com.min.dnapp.presentation.ui.icon.appicons.Bell
import com.min.dnapp.presentation.ui.icon.appicons.Calendar
import com.min.dnapp.presentation.ui.icon.appicons.Gallery
import com.min.dnapp.presentation.ui.icon.appicons.Kakao
import com.min.dnapp.presentation.ui.icon.appicons.PenSmall
import kotlin.collections.List as ____KtList

public object AppIcons

private var __AllIcons: ____KtList<ImageVector>? = null

public val AppIcons.AllIcons: ____KtList<ImageVector>
  get() {
    if (__AllIcons != null) {
      return __AllIcons!!
    }
    __AllIcons= listOf(Back, Bell, Calendar, Gallery, Kakao, PenSmall)
    return __AllIcons!!
  }
