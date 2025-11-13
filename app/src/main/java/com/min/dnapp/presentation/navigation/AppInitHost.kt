package com.min.dnapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.min.dnapp.presentation.init.AppInitViewModel
import com.min.dnapp.presentation.init.InitRoute
import com.min.dnapp.presentation.init.LoadingScreen
import com.min.dnapp.presentation.init.OnboardingScreen
import com.min.dnapp.presentation.init.OnboardingScreen2
import com.min.dnapp.presentation.init.OnboardingScreen3
import com.min.dnapp.presentation.init.ProfileSetupScreen

@Composable
fun AppInitHost(
    appInitViewModel: AppInitViewModel = hiltViewModel(),
    onInitComplete: () -> Unit
) {
    val uiState by appInitViewModel.uiState.collectAsStateWithLifecycle()

    // nested navigation 담당 (인증 후)
    val navController = rememberNavController()

    // 초기 상태에 따라 시작 경로 결정
    val startDestination = when (uiState.route) {
        InitRoute.LOADING -> "loading"
        InitRoute.ONBOARDING -> "onboarding_flow"
        InitRoute.PROFILE_SETUP -> "profile_setup"
        InitRoute.MAIN -> {
            // 1번만 실행
            LaunchedEffect(Unit) {
                onInitComplete()
            }
            // NavHost 렌더링 중단
            return
        }
    }

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable("loading") {
            LoadingScreen()
        }

        navigation(
            startDestination = "onboarding",
            route = "onboarding_flow"
        ) {
            composable("onboarding") {
                OnboardingScreen(
                    onFinish = {
                        navController.navigate("onboarding2")
                    }
                )
            }
            composable("onboarding2") {
                OnboardingScreen2(
                    navController = navController,
                    onFinish = {
                        navController.navigate("onboarding3")
                    }
                )
            }
            composable("onboarding3") {
                OnboardingScreen3(
                    navController = navController,
                    onFinish = {
                        appInitViewModel.onOnboardingFinished()
                        navController.navigate("profile_setup") {
                            popUpTo("onboarding_flow") { inclusive = true }
                        }
                    }
                )
            }
        }

        composable("profile_setup") {
            ProfileSetupScreen(
                onFinish = {
                    appInitViewModel.onProfileSetupFinished()
                    onInitComplete()
                }
            )
        }
    }
}
