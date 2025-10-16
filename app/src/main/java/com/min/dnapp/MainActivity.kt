package com.min.dnapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.min.dnapp.presentation.AppStartViewModel
import com.min.dnapp.presentation.find.FindDetailScreen
import com.min.dnapp.presentation.find.FindScreen
import com.min.dnapp.presentation.home.HomeScreen
import com.min.dnapp.presentation.home.HomeScreen2
import com.min.dnapp.presentation.login.LoginScreen
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
//                MomentoApp()
//                LoginScreen2()
//                OnboardingScreen()
//                OnboardingScreen2()
//                OnboardingScreen3()
//                ProfileSetupScreen()
//                MypageScreen()
//                SettingScreen()
//                RecordWriteScreen()
//                WriteFinishScreen()
//                FindScreen()
//                FindDetailScreen()
                HomeScreen2()
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

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        NavHost(
            navController = navController,
            startDestination = startDestination
        ) {
            composable("login") {
                LoginScreen(navController = navController)
            }

            composable("home") {
                HomeScreen(navController = navController)
            }
        }
    }
}
