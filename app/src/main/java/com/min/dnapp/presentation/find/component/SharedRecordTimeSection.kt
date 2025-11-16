package com.min.dnapp.presentation.find.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.min.dnapp.R
import com.min.dnapp.presentation.common.BadgeMapper
import com.min.dnapp.presentation.ui.theme.MomentoTheme
import com.min.dnapp.util.toTimeAgoString

@Composable
fun SharedRecordTimeSection(
    nickname: String,
    badgeLv: Int,
    createdAtMillis: Long
) {
    val imageResId = BadgeMapper.getBadgeImageResId(badgeLv)

    // 경과 시간 텍스트 (현재 시간 기준으로 공유된 시간 계산)
    val timeAgoText = createdAtMillis.toTimeAgoString()

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = nickname,
            style = MomentoTheme.typography.body01,
            color = MomentoTheme.colors.grayW20
        )
        Image(
            modifier = Modifier.size(20.dp),
//            painter = painterResource(R.drawable.badge_bronze),
            painter = painterResource(imageResId),
            contentDescription = null
        )
        Spacer(Modifier.width(4.dp))
        Text(
            text = timeAgoText,
            style = MomentoTheme.typography.body02,
            color = MomentoTheme.colors.grayW20
        )
    }
}
