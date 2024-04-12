package com.example.vocational_compose.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavigationGraph(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.HOME_CHIOCE_SCREEN) {
        composable(Routes.HOME_CHIOCE_SCREEN) {
            HomeChoiceScreen(navController)
        }

        composable(Routes.LOGIN_USER_SCREEN) {
            LoginUserScreen(navController)
        }

        composable(Routes.LOGIN_COMPANY_SCREEN) {
            LoginCompanyScreen(navController)
        }

    }
}