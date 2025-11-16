package com.min.dnapp.presentation.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.min.dnapp.presentation.common.BadgeMapper
import com.min.dnapp.presentation.ui.theme.MomentoTheme

@Composable
fun UserBadge(
    badgeLv: Int,
    badgeName: String
) {
    // badgeLv을 통해 매핑된 이미지 리소스 ID
    val badgeImageResId = BadgeMapper.getBadgeImageResId(badgeLv)

    Row(
        modifier = Modifier
            .background(color = MomentoTheme.colors.white, shape = RoundedCornerShape(20.dp))
            .padding(horizontal = 12.dp, vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier.size(24.dp),
            painter = painterResource(badgeImageResId),
            contentDescription = null
        )
        Spacer(Modifier.width(4.dp))
        Text(
            text = badgeName,
//            style = MomentoTheme.typography.caption,
            style = MomentoTheme.typography.body03,
            color = MomentoTheme.colors.grayW20
        )
    }
}
