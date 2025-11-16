package com.min.dnapp.presentation.write

import com.min.dnapp.domain.model.Badge

sealed class WriteFinishDialogState {
    data object Hidden: WriteFinishDialogState()
    data object StampDialog: WriteFinishDialogState()
    data class BadgeDialog(val badge: Badge): WriteFinishDialogState()
}
