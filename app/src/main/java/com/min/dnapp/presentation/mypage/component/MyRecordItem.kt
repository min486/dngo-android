package com.min.dnapp.presentation.mypage.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.min.dnapp.domain.model.TripRecord
import com.min.dnapp.presentation.find.component.SharedRecordContentSection
import com.min.dnapp.presentation.ui.theme.DngoTheme

@Composable
fun MyRecordItem(
    record: TripRecord,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
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
    }
}

@Preview
@Composable
fun MyRecordItemPreview() {
    DngoTheme {
//        MyRecordItem()
    }
}
