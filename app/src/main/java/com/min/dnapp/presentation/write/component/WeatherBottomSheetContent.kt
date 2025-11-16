package com.min.dnapp.presentation.write.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.min.dnapp.R
import com.min.dnapp.domain.model.WeatherType
import com.min.dnapp.presentation.ui.component.SelectButton
import com.min.dnapp.presentation.ui.theme.MomentoTheme

@Composable
fun WeatherBottomSheetContent(
    onConfirm: (WeatherType) -> Unit
) {
    // 선택된 WeatherType 객체 저장
    var selectedWeather by remember { mutableStateOf<WeatherType?>(null) }
    // weather 선택 시 버튼 활성화
    val isButtonEnabled = selectedWeather != null

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

        Spacer(Modifier.height(12.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            // sun / wind / moon
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                WeatherItem(
                    weatherType = WeatherType.SUN,
                    isSelected = selectedWeather == WeatherType.SUN,
                    onSelect = { weatherType -> selectedWeather = weatherType }
                )
                WeatherItem(
                    weatherType = WeatherType.WIND,
                    isSelected = selectedWeather == WeatherType.WIND,
                    onSelect = { weatherType -> selectedWeather = weatherType }
                )
                WeatherItem(
                    weatherType = WeatherType.MOON,
                    isSelected = selectedWeather == WeatherType.MOON,
                    onSelect = { weatherType -> selectedWeather = weatherType }
                )
            }

            // thunder / rain / cloud
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                WeatherItem(
                    weatherType = WeatherType.THUNDER,
                    isSelected = selectedWeather == WeatherType.THUNDER,
                    onSelect = { weatherType -> selectedWeather = weatherType }
                )
                WeatherItem(
                    weatherType = WeatherType.RAIN,
                    isSelected = selectedWeather == WeatherType.RAIN,
                    onSelect = { weatherType -> selectedWeather = weatherType }
                )
                WeatherItem(
                    weatherType = WeatherType.CLOUD,
                    isSelected = selectedWeather == WeatherType.CLOUD,
                    onSelect = { weatherType -> selectedWeather = weatherType }
                )
            }

            // snow
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                WeatherItem(
                    weatherType = WeatherType.SNOW,
                    isSelected = selectedWeather == WeatherType.SNOW,
                    onSelect = { weatherType -> selectedWeather = weatherType }
                )
            }
        }

        Spacer(Modifier.height(32.dp))

        // 선택 버튼
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            SelectButton(
                enabled = isButtonEnabled,
                onConfirm = {
                    selectedWeather?.let(onConfirm)
                }
            )
            Spacer(Modifier.height(16.dp))
        }
    }
}

@Composable
fun WeatherItem(
    weatherType: WeatherType,
    isSelected: Boolean,
    onSelect: (WeatherType) -> Unit
) {
    Box(
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.clickable {
                onSelect(weatherType)
            },
            painter = painterResource(weatherType.resId),
            contentDescription = null
        )
        if (isSelected) {
            Image(
                modifier = Modifier.size(48.dp),
                painter = painterResource(R.drawable.ew_check),
                contentDescription = null
            )
        }
    }
}
