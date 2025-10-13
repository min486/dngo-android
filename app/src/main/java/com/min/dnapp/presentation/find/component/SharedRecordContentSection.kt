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
import com.min.dnapp.R
import com.min.dnapp.presentation.ui.theme.MomentoTheme

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
