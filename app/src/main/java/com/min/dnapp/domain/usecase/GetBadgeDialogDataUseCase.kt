package com.min.dnapp.domain.usecase

import com.min.dnapp.domain.getNewBadgeData
import com.min.dnapp.domain.model.Badge
import javax.inject.Inject

class GetBadgeDialogDataUseCase @Inject constructor() {
    operator fun invoke(totalStamp: Int): Badge? {
        return getNewBadgeData(totalStamp)
    }
}
