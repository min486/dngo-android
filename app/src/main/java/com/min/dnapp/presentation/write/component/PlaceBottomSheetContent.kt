package com.min.dnapp.presentation.write.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.min.dnapp.domain.model.LocalPlace
import com.min.dnapp.presentation.ui.component.SelectButton
import com.min.dnapp.presentation.ui.theme.DngoTheme
import com.min.dnapp.presentation.ui.theme.MomentoTheme
import com.min.dnapp.presentation.write.SearchState

@Composable
fun PlaceBottomSheetContent(
    searchState: SearchState,
    onValueChange: (String) -> Unit,
    onSearch: () -> Unit,
    onClear: () -> Unit,
    onConfirm: (LocalPlace) -> Unit,
) {
    // 검색 결과 목록에서 선택된 아이템
    var selectedPlace by remember { mutableStateOf<LocalPlace?>(null) }

    // UI 컨트롤러
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
            if (searchState.query.isEmpty()) {
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
                            selectedPlace = null
                            onClear()
                        }
                    },
                value = searchState.query,
                onValueChange = onValueChange,
                textStyle = MomentoTheme.typography.body01,
                singleLine = true,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                keyboardActions = KeyboardActions(
                    onSearch = { onSearchAction() }
                )
            )
        }

        Spacer(Modifier.height(20.dp))

        // 검색 진행 시 로딩 인디케이터 표시
        if (searchState.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.size(40.dp),
                color = MomentoTheme.colors.brownW20,
                strokeWidth = 4.dp
            )
        }

        // 검색 결과 목록
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            searchState.places.forEach { item ->
                PlaceItem(
                    placeName = item.title,
                    placeCategory = item.category,
                    placeRoadAddress = item.roadAddress,
                    isSelected = selectedPlace == item,
                    onClick = { selectedPlace = item }
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
                enabled = selectedPlace != null,
                onConfirm = {
                    // 콜백으로 이벤트 전달
                    selectedPlace?.let(onConfirm)
                }
            )
            Spacer(Modifier.height(16.dp))
        }
    }
}

@Composable
fun PlaceItem(
    placeName: String,
    placeCategory: String,
    placeRoadAddress: String,
    isSelected: Boolean = false,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .clickable { onClick() }
            .fillMaxWidth()
            .background(
                if (isSelected) MomentoTheme.colors.brownW80 else Color.Transparent
            )
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
