package com.min.dnapp.presentation.find.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.min.dnapp.R
import com.min.dnapp.presentation.ui.theme.MomentoTheme
import com.min.dnapp.util.toDateString

@Composable
fun SharedRecordContentSection(
    title: String,
    content: String,
    startDateMillis: Long,
    endDateMillis: Long?,
    placeName: String?,
    imageUrl: String?
) {
    val startDate = startDateMillis.toDateString("yy.MM.dd")
    val endDate = endDateMillis?.toDateString("yy.MM.dd")

    // 여행 날짜 텍스트 계산
    val dateText = endDate?.let { "$startDate ~ $it" } ?: startDate

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = MomentoTheme.colors.brownW90)
            .padding(horizontal = 16.dp)
    ) {
        Spacer(Modifier.height(16.dp))

        // 여행 제목
        Text(
            text = title,
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
            // 여행 날짜
            Text(
                text = dateText,
                style = MomentoTheme.typography.body03,
                color = MomentoTheme.colors.grayW20
            )

            // 날씨 & 감정
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

        // 여행 장소
        placeName?.let { place ->
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.write_place),
                    contentDescription = null
                )
                Spacer(Modifier.width(6.dp))
                Text(
                    text = place,
                    style = MomentoTheme.typography.body03 ,
                    color = MomentoTheme.colors.grayW20
                )
            }
        }

        Spacer(Modifier.height(6.dp))

        // 여행 내용
        Text(
            text = content,
            style = MomentoTheme.typography.body02,
            color = MomentoTheme.colors.grayW20
        )

        Spacer(Modifier.height(6.dp))

        // 여행 이미지
        imageUrl?.let { image ->
            AsyncImage(
                modifier = Modifier.fillMaxWidth(),
                model = image,
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }

        Spacer(Modifier.height(12.dp))
    }
}
