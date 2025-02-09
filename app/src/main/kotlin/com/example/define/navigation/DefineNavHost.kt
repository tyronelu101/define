package com.example.define.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.define.feature.dictionary.navigation.HomeRoute
import com.example.define.feature.dictionary.navigation.homeScreen
import com.example.define.feature.dictionary.navigation.navigateToLanguageSelection
import com.example.define.feature.dictionary.navigation.navigateToSearch
import com.example.define.feature.settings.navigation.settingsScreen

@Composable
fun DefineNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = HomeRoute) {
        homeScreen(
            onSearchClick = navController::navigateToSearch,
            onLanguageClick = navController::navigateToLanguageSelection,
            onBackClick = navController::popBackStack
        )
        settingsScreen()
    }
}
