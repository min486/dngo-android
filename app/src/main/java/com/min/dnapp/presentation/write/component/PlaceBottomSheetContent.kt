package com.min.dnapp.presentation.write.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.min.dnapp.domain.model.LocalPlace
import com.min.dnapp.presentation.ui.component.SelectButton
import com.min.dnapp.presentation.ui.theme.DngoTheme
import com.min.dnapp.presentation.ui.theme.MomentoTheme

@Composable
fun PlaceBottomSheetContent(
    value: String,
    places: List<LocalPlace>,
    onValueChange: (String) -> Unit,
    onSearch: () -> Unit,
    onConfirm: () -> Unit,
    onClear: () -> Unit
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    val onSearchAction = {
        // 여행지 검색 실행
        onSearch()
        // 키보드 숨기기
        keyboardController?.hide()
        // 포커스 해제
        focusManager.clearFocus()
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
//            .padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(20.dp))

        Box(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth()
                .border(width = 1.dp, color = MomentoTheme.colors.grayW80, shape = RoundedCornerShape(6.dp))
                .padding(horizontal = 16.dp, vertical = 12.dp)
        ) {
            if (value.isEmpty()) {
                Text(
                    text = "여행지를 입력해주세요",
                    style = MomentoTheme.typography.body01,
                    color = MomentoTheme.colors.grayW60
                )
            }
            BasicTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .onFocusChanged { focusState ->
                        if (focusState.isFocused) {
                            onClear()
                        }
                    },
                value = value,
                onValueChange = onValueChange,
                textStyle = MomentoTheme.typography.body01,
                singleLine = true,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                keyboardActions = KeyboardActions(
                    onSearch = { onSearchAction() }
                )
            )
        }

        // 검색 결과 목록
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            places.forEach { item ->
                PlaceItem(
                    placeName = item.title,
                    placeCategory = item.category,
                    placeRoadAddress = item.roadAddress
                )
            }
        }

        Spacer(Modifier.height(20.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            SelectButton(
                enabled = false,
                onConfirm = {}
            )
            Spacer(Modifier.height(16.dp))
        }
    }
}

@Composable
fun PlaceItem(
    placeName: String,
    placeCategory: String,
    placeRoadAddress: String
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = placeName,
                style = MomentoTheme.typography.body01,
                color = MomentoTheme.colors.grayW20
            )
            Text(
                text = placeCategory,
                style = MomentoTheme.typography.body02,
                color = MomentoTheme.colors.grayW40
            )
        }
        Spacer(Modifier.height(4.dp))
        Text(
            text = placeRoadAddress,
            style = MomentoTheme.typography.body02,
            color = MomentoTheme.colors.grayW60
        )
    }
    HorizontalDivider(thickness = 1.dp, color = MomentoTheme.colors.grayW80)
}

@Preview(showBackground = true)
@Composable
fun PlaceBottomSheetContentPreview() {
    DngoTheme {
//        PlaceBottomSheetContent(
//            value = "",
//            onValueChange = {},
//            onConfirm = {}
//        )
    }
}
