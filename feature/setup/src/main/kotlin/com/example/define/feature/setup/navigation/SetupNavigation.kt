//package com.example.define.feature.setup.navigation
//
//import androidx.navigation.NavController
//import androidx.navigation.NavGraphBuilder
//import androidx.navigation.NavOptions
//import androidx.navigation.compose.composable
//import com.example.define.feature.setup.SetupRoute
//
//const val SETUP_ROUTE = "setup_route"
//
//fun NavController.navigateToSetup(navOptions: NavOptions) = navigate(SETUP_ROUTE, navOptions)
//
//fun NavGraphBuilder.setupScreen() {
//    composable(route = SETUP_ROUTE) {
//        SetupRoute()
//    }
//}