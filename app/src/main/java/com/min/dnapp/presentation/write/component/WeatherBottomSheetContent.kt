package com.min.dnapp.presentation.write.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.min.dnapp.R
import com.min.dnapp.presentation.ui.theme.MomentoTheme

@Composable
fun WeatherBottomSheetContent(
    onConfirm: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(20.dp))

        Text(
            text = "날씨는 어땠나요?",
            style = MomentoTheme.typography.title02,
            color = MomentoTheme.colors.grayW20
        )

        Spacer(Modifier.height(20.dp))

        HorizontalDivider(thickness = 1.dp, color = MomentoTheme.colors.grayW90)

        Spacer(Modifier.height(12 .dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Image(
                    modifier = Modifier.clickable {  },
                    painter = painterResource(R.drawable.weather_sun),
                    contentDescription = null
                )
                Image(
                    modifier = Modifier.clickable {  },
                    painter = painterResource(R.drawable.weather_wind),
                    contentDescription = null
                )
                Image(
                    modifier = Modifier.clickable {  },
                    painter = painterResource(R.drawable.weather_moon),
                    contentDescription = null
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Image(
                    modifier = Modifier.clickable {  },
                    painter = painterResource(R.drawable.weather_thunder),
                    contentDescription = null
                )
                Image(
                    modifier = Modifier.clickable {  },
                    painter = painterResource(R.drawable.weather_rain),
                    contentDescription = null
                )
                Image(
                    modifier = Modifier.clickable {  },
                    painter = painterResource(R.drawable.weather_cloud),
                    contentDescription = null
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    modifier = Modifier.clickable {  },
                    painter = painterResource(R.drawable.weather_snow),
                    contentDescription = null
                )
            }
        }

        Spacer(Modifier.height(32.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            Box(
                modifier = Modifier
                    .clickable { onConfirm() }
                    .fillMaxWidth()
                    .background(color = MomentoTheme.colors.brownBase, shape = RoundedCornerShape(10.dp))
                    .padding(vertical = 16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "선택했어요",
                    style = MomentoTheme.typography.body01,
                    color = MomentoTheme.colors.white
                )
            }
            Spacer(Modifier.height(16.dp))
        }
    }
}
