package com.example.define.feature.dictionary.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.define.feature.dictionary.HomeRoute
import com.example.define.feature.dictionary.SearchRoute
import com.example.define.feature.dictionary.LanguageRoute
import com.example.define.feature.dictionary.types.LanguageSelectionType
import kotlinx.serialization.Serializable

@Serializable
data object HomeRoute

@Serializable
data class LanguageRoute(val type: LanguageSelectionType)

@Serializable
data object SearchRoute

fun NavController.navigateToSearch() =
    navigate(HomeRoute)

fun NavController.navigateToLanguageSelection(type: LanguageSelectionType) =
    navigate(route = LanguageRoute(type))

fun NavGraphBuilder.homeScreen(
    onSearchClick: () -> Unit,
    onLanguageClick: (type: LanguageSelectionType) -> Unit,
    onBackClick: () -> Unit
) {
    composable<HomeRoute> {
        HomeRoute(onSearchClick = onSearchClick, onLanguageClick = onLanguageClick)
    }
    composable<LanguageRoute> {
        LanguageRoute(
            onBackClick = onBackClick,
        )
    }
    composable<SearchRoute> { SearchRoute() }
}