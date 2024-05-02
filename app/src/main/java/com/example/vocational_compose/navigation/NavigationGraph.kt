package com.example.vocational_compose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.vocational_compose.MainActivity
import com.example.vocational_compose.presentation.screens.GeneralScreen
import com.example.vocational_compose.presentation.screens.HomeChoiceScreen
import com.example.vocational_compose.presentation.screens.LoginCompanyScreen
import com.example.vocational_compose.presentation.screens.LoginUserScreen
import com.example.vocational_compose.presentation.screens.OfferShowcase
import com.example.vocational_compose.presentation.viewmodel.LoginViewModel
import com.example.vocational_compose.presentation.viewmodel.OfferViewModel

@Composable
fun NavigationGraph(
    offerViewModel: OfferViewModel,
    loginViewModel: LoginViewModel,
    mainActivity: MainActivity
){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.HOME_CHIOCE_SCREEN) {
        composable(Routes.HOME_CHIOCE_SCREEN) {
            HomeChoiceScreen(navController)
        }

        composable(Routes.LOGIN_USER_SCREEN) {
            LoginUserScreen(navController, loginViewModel, mainActivity)
        }

        composable(Routes.LOGIN_COMPANY_SCREEN) {
            LoginCompanyScreen(navController, loginViewModel, mainActivity)
        }

        composable(Routes.OFFER_SHOWCASE) {
            OfferShowcase(navController, offerViewModel)
        }

        composable(Routes.AFTER_SCREEN) {
            GeneralScreen(navController)
        }



    }
}