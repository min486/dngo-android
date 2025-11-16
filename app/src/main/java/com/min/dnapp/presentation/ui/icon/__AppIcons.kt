package com.min.dnapp.presentation.ui.icon

import androidx.compose.ui.graphics.vector.ImageVector
import com.min.dnapp.presentation.ui.icon.appicons.ArrowRight
import com.min.dnapp.presentation.ui.icon.appicons.Back
import com.min.dnapp.presentation.ui.icon.appicons.Bell
import com.min.dnapp.presentation.ui.icon.appicons.Calendar
import com.min.dnapp.presentation.ui.icon.appicons.Delete
import com.min.dnapp.presentation.ui.icon.appicons.DeleteLine
import com.min.dnapp.presentation.ui.icon.appicons.Explore
import com.min.dnapp.presentation.ui.icon.appicons.Gallery
import com.min.dnapp.presentation.ui.icon.appicons.Home
import com.min.dnapp.presentation.ui.icon.appicons.Kakao
import com.min.dnapp.presentation.ui.icon.appicons.More
import com.min.dnapp.presentation.ui.icon.appicons.My
import com.min.dnapp.presentation.ui.icon.appicons.Pen
import com.min.dnapp.presentation.ui.icon.appicons.PenSmall
import com.min.dnapp.presentation.ui.icon.appicons.RecordBest
import com.min.dnapp.presentation.ui.icon.appicons.RecordBookmark
import com.min.dnapp.presentation.ui.icon.appicons.RecordComment
import com.min.dnapp.presentation.ui.icon.appicons.RecordLike
import com.min.dnapp.presentation.ui.icon.appicons.RecordSurprise
import com.min.dnapp.presentation.ui.icon.appicons.ShareTriangle
import com.min.dnapp.presentation.ui.icon.appicons.Year
import kotlin.collections.List as ____KtList

public object AppIcons

private var __AllIcons: ____KtList<ImageVector>? = null

public val AppIcons.AllIcons: ____KtList<ImageVector>
  get() {
    if (__AllIcons != null) {
      return __AllIcons!!
    }
    __AllIcons= listOf(ArrowRight, Back, Bell, Calendar, Delete, DeleteLine, Explore, Gallery, Home,
        Kakao, More, My, Pen, PenSmall, RecordBest, RecordBookmark, RecordComment, RecordLike,
        RecordSurprise, ShareTriangle, Year)
    return __AllIcons!!
  }
