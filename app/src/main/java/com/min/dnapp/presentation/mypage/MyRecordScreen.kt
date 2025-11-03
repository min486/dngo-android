package com.min.dnapp.presentation.mypage

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.min.dnapp.presentation.mypage.component.MyRecordItem
import com.min.dnapp.presentation.ui.icon.AppIcons
import com.min.dnapp.presentation.ui.icon.appicons.Back
import com.min.dnapp.presentation.ui.theme.MomentoTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyRecordScreen(
    navController: NavHostController,
    myRecordViewModel: MyRecordViewModel = hiltViewModel()
) {
    val uiState by myRecordViewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        containerColor = MomentoTheme.colors.brownBg,
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "내 기록 모아보기",
                        style = MomentoTheme.typography.title02,
                        color = MomentoTheme.colors.grayW20
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    MomentoTheme.colors.brownBg
                ),
                navigationIcon = {
                    Icon(
                        modifier = Modifier
                            .clickable { navController.popBackStack() }
                            .padding(16.dp),
                        imageVector = AppIcons.Back,
                        contentDescription = null
                    )
                }
            )
        }
    ) { paddingValues ->

        when (uiState) {
            is MyRecordUiState.Loading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(40.dp),
                        color = MomentoTheme.colors.brownW20,
                        strokeWidth = 4.dp
                    )
                }
            }
            is MyRecordUiState.Error -> {}
            is MyRecordUiState.Success -> {
                // Success 데이터 추출
                val data = uiState as MyRecordUiState.Success

                LazyColumn(
                    modifier = Modifier
                        .padding(paddingValues)
                        .fillMaxSize()
                ) {
                    itemsIndexed(data.records) { idx, record ->
                        Box(
                            modifier = Modifier.padding(20.dp)
                        ) {
                            // 내 여행기록 아이템
                            MyRecordItem(
                                record = record,
                                onClick = {}
                            )
                        }

                        if (idx < data.records.size - 1) {
                            HorizontalDivider(thickness = 1.dp, color = MomentoTheme.colors.grayW80)
                        }
                    }
                }
            }
        }
    }
}
