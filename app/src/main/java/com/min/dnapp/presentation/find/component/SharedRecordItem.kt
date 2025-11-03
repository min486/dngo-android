package com.min.dnapp.presentation.find.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.min.dnapp.domain.model.TripRecord
import com.min.dnapp.presentation.ui.profile.ProfileImageCircle
import com.min.dnapp.presentation.ui.theme.DngoTheme
import com.min.dnapp.presentation.ui.theme.MomentoTheme

@Composable
fun SharedRecordItem(
    record: TripRecord,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
//            .clickable { onClick() }
            .fillMaxWidth()
    ) {
        // 프로필 이미지
        ProfileImageCircle(
            profileImageName = record.userData?.profileImageName,
            modifier = Modifier.size(36.dp)
        )

        Spacer(Modifier.width(8.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {
            // 공유 경과시간 영역
            SharedRecordTimeSection(
                nickname = record.userData?.nickname ?: "",
                badgeLv = record.userData?.badgeLv ?: 1
            )

            Spacer(Modifier.height(8.dp))

            Text(
                text = "${record.userData?.nickname}님이 여행 기록을 공유했어요.",
                style = MomentoTheme.typography.body01,
                color = MomentoTheme.colors.grayW20
            )

            Spacer(Modifier.height(8.dp))

            // 기록 전체내용
            SharedRecordContentSection(
                title = record.title,
                content = record.content,
                startDateMillis = record.startDateMillis,
                endDateMillis = if (record.endDateMillis == 0L) null else record.endDateMillis,
                weatherName = record.weatherKey,
                emotionName = record.emotionKey,
                placeName = record.selectedPlace?.title,
                imageUrl = if (record.imageUrl.isEmpty()) null else record.imageUrl
            )

//            Spacer(Modifier.height(12.dp))
//
//            // 반응 이모지 영역
//            FindReactionIconSection(
//                bestNum = 1,
//                likeNum = 2,
//                surpriseNum = 12,
//                commentNum = 2
//            )
        }
    }
}

@Preview
@Composable
fun RecordItemPreview() {
    DngoTheme {
//        SharedRecordItem()
    }
}
