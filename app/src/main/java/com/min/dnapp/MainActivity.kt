package com.min.dnapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.min.dnapp.presentation.AppStartViewModel
import com.min.dnapp.presentation.home.HomeScreen
import com.min.dnapp.presentation.login.LoginScreen
import com.min.dnapp.presentation.login.LoginScreen2
import com.min.dnapp.presentation.ui.theme.DngoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            DngoTheme {
//                MomentoApp()
                LoginScreen2()
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
