package com.min.dnapp.presentation.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.min.dnapp.R
import com.min.dnapp.presentation.ui.icon.AppIcons
import com.min.dnapp.presentation.ui.icon.appicons.Explore
import com.min.dnapp.presentation.ui.icon.appicons.Home
import com.min.dnapp.presentation.ui.icon.appicons.My
import com.min.dnapp.presentation.ui.theme.DngoTheme
import com.min.dnapp.presentation.ui.theme.MomentoTheme

data class BottonNavItem(
    val icon: ImageVector,
    val selectedIcon: Int,
    val label: String,
    val route: String
)

@Composable
fun MomentoBottomNav(
    currentRoute: String,
    onNavItemClick: (String) -> Unit
) {
    val items = listOf(
        BottonNavItem(AppIcons.Home, R.drawable.ic_home, "Home", "home"),
        BottonNavItem(AppIcons.Explore, R.drawable.ic_explore, "Discover", "find"),
        BottonNavItem(AppIcons.My, R.drawable.ic_my, "My", "my")
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            // bottomNav가 navigationBar 위에 올라가도록 padding 처리
            .navigationBarsPadding()
    ) {
        HorizontalDivider(thickness = 1.dp, color = MomentoTheme.colors.grayW90)

        Row(
            modifier = Modifier
                .fillMaxWidth()
//                .height(56.dp)
                .height(58.dp)
                .background(color = MomentoTheme.colors.white),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            items.forEach { item ->
                val selected = currentRoute == item.route

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .clickable(
                            // 리플효과 제거
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        ) {
                            onNavItemClick(item.route)
                        },
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(Modifier.height(6.dp))

                    // bottomBar 아이콘
                    if (selected) {
                        Image(
                            painter = painterResource(item.selectedIcon),
                            contentDescription = null
                        )
                    } else {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = null,
                            tint = if (selected) MomentoTheme.colors.brownBase else MomentoTheme.colors.grayW60
                        )
                    }

                    Text(
                        text = item.label,
                        style = MomentoTheme.typography.label,
                        color = if (selected) MomentoTheme.colors.brownB40 else MomentoTheme.colors.grayW60
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun MomentoBottomNavPreview() {
    DngoTheme {
        MomentoBottomNav(
            currentRoute = "home"
        ) { }
    }
}
