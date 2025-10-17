package com.min.dnapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.min.dnapp.presentation.AppStartViewModel
import com.min.dnapp.presentation.find.FindScreen
import com.min.dnapp.presentation.home.HomeScreen2
import com.min.dnapp.presentation.login.LoginScreen
import com.min.dnapp.presentation.mypage.MypageScreen
import com.min.dnapp.presentation.ui.component.MomentoBottomNav
import com.min.dnapp.presentation.ui.theme.DngoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // 스플래시 화면 설정
        val splashScreen = installSplashScreen()

        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            DngoTheme {
                MomentoApp()
            }
        }
    }
}

@Composable
fun MomentoApp(
    appStartViewModel: AppStartViewModel = hiltViewModel()
) {
    val isLogin by appStartViewModel.isLogin.collectAsStateWithLifecycle()
    val startDestination = if (isLogin) "home" else "login"

    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: "home"

    Scaffold(
        bottomBar = {
            MomentoBottomNav(
                currentRoute = currentRoute,
                onNavItemClick = { route ->
                    // 현재 경로와 다를때만 navigate 호출
                    if (navController.currentDestination?.route != route) {
                        navController.navigate(route)
                    }
                }
            )
        }
    ) { paddingValues ->
        NavHost(
            modifier = Modifier.padding(paddingValues),
            navController = navController,
//            startDestination = startDestination
            startDestination = "home"
        ) {
            composable("login") {
                LoginScreen(navController = navController)
            }
            composable("home") {
                HomeScreen2()
            }
            composable("explore") {
                FindScreen()
            }
            composable("my") {
                MypageScreen()
            }
        }
    }
}
