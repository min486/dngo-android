package com.min.dnapp.presentation.find

import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.min.dnapp.R
import com.min.dnapp.presentation.find.component.SharedRecordItem
import com.min.dnapp.presentation.ui.icon.AppIcons
import com.min.dnapp.presentation.ui.icon.appicons.Bell
import com.min.dnapp.presentation.ui.theme.DngoTheme
import com.min.dnapp.presentation.ui.theme.MomentoTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FindScreen(
    navController: NavHostController,
    findViewModel: FindViewModel = hiltViewModel()
) {
    val uiState by findViewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        containerColor = MomentoTheme.colors.brownBg,
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MomentoTheme.colors.brownBg
                ),
                navigationIcon = {
                    Image(
                        modifier = Modifier
                            .clickable {  }
                            .padding(16.dp),
                        painter = painterResource(R.drawable.logo_momento),
                        contentDescription = null
                    )
                },
                actions = {
                    Icon(
                        modifier = Modifier
                            .clickable {  }
                            .padding(16.dp),
                        imageVector = AppIcons.Bell,
                        contentDescription = null,
                        tint = MomentoTheme.colors.grayW60
                    )
                }
            )
        }
    ) { paddingValues ->

        when (uiState) {
            is FindUiState.Loading -> {
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
            is FindUiState.Error -> {}
            is FindUiState.Success -> {
                // Success 데이터 추출
                val data = uiState as FindUiState.Success

                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                ) {
                    item {
                        HorizontalDivider(thickness = 1.dp, color = MomentoTheme.colors.grayW80)
                    }

                    itemsIndexed(data.records) { idx, record ->
                        Box(
                            modifier = Modifier.padding(20.dp)
                        ) {
                            // 발견 탭에 공유된 여행기록 아이템
                            SharedRecordItem(
                                record = record,
                                onClick = {
//                                    navController.navigate("explore_detail")
                                }
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

@Preview
@Composable
fun FindScreenPreview() {
    DngoTheme {
//        FindScreen()
    }
}
