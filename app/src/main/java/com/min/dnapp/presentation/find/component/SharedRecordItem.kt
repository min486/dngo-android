package com.min.dnapp.presentation.find.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.min.dnapp.R
import com.min.dnapp.presentation.ui.theme.DngoTheme
import com.min.dnapp.presentation.ui.theme.MomentoTheme

@Composable
fun SharedRecordItem() {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        // 프로필 이미지
        Box(
            modifier = Modifier
                .size(36.dp)
                .clip(CircleShape)
                .border(width = 2.dp, color = MomentoTheme.colors.grayW90, shape = CircleShape)
        ) {
            Image(
                painter = painterResource(R.drawable.logo_profile),
                contentDescription = null
            )
        }

        Spacer(Modifier.width(8.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {
            // 닉네임 + 공유 안내
            SharedRecordHeaderSection()

            Spacer(Modifier.height(8.dp))

            // 기록 내용
            SharedRecordContentSection()

            Spacer(Modifier.height(12.dp))

            // 반응 이모지 영역
            FindReactionIconSection(
                bestNum = 1,
                likeNum = 2,
                surpriseNum = 12,
                commentNum = 2
            )
        }
    }
}

@Composable
fun SharedRecordHeaderSection() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "시골청년",
                style = MomentoTheme.typography.body01,
                color = MomentoTheme.colors.grayW20
            )
            Image(
                modifier = Modifier.size(20.dp),
                painter = painterResource(R.drawable.badge_bronze),
                contentDescription = null
            )
            Spacer(Modifier.width(4.dp))
            Text(
                text = "2분 전",
                style = MomentoTheme.typography.body02,
                color = MomentoTheme.colors.grayW20
            )
        }

        Spacer(Modifier.height(8.dp))

        Text(
            text = "시골청년님이 여행 기록을 공유했어요.",
            style = MomentoTheme.typography.body01,
            color = MomentoTheme.colors.grayW20
        )
    }
}

@Composable
fun SharedRecordContentSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = MomentoTheme.colors.brownW90)
            .padding(horizontal = 16.dp)
    ) {
        Spacer(Modifier.height(16.dp))

        Text(
            text = "제주도 동쪽 투어!",
            style = MomentoTheme.typography.label,
            color = MomentoTheme.colors.grayW20
        )

        Spacer(Modifier.height(6.dp))

        HorizontalDivider(thickness = 1.dp, color = MomentoTheme.colors.pinkBase)

        Spacer(Modifier.height(4.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "25.08.20 ~ 25.08.22",
                style = MomentoTheme.typography.body03,
                color = MomentoTheme.colors.grayW20
            )

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    modifier = Modifier.size(28.dp),
                    painter = painterResource(R.drawable.weather_sun),
                    contentDescription = null
                )
                Spacer(Modifier.width(4.dp))
                Image(
                    modifier = Modifier.size(28.dp),
                    painter = painterResource(R.drawable.emotion_feel),
                    contentDescription = null
                )
            }
        }

        Spacer(Modifier.height(4.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.write_place),
                contentDescription = null
            )
            Spacer(Modifier.width(6.dp))
            Text(
                text = "제주특별자치도",
                style = MomentoTheme.typography.body03 ,
                color = MomentoTheme.colors.grayW20
            )
        }

        Spacer(Modifier.height(6.dp))

        Text(
            text = "비 오는 날 이호해수욕장... 너무 좋았어요",
            style = MomentoTheme.typography.body02 ,
            color = MomentoTheme.colors.grayW20
        )

        Spacer(Modifier.height(6.dp))

        Image(
            modifier = Modifier.fillMaxWidth(),
            painter = painterResource(R.drawable.beach ),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Spacer(Modifier.height(12.dp))
    }
}

@Preview
@Composable
fun RecordItemPreview() {
    DngoTheme {
        SharedRecordItem()
    }
}
