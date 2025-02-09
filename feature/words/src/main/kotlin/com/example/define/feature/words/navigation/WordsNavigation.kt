package com.example.define.feature.words.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.example.define.feature.words.WordsRoute
import kotlinx.serialization.Serializable


@Serializable
object WordsRoute

fun NavController.navigateToWords(navOptions: NavOptions) =
    navigate(WordsRoute, navOptions)

fun NavGraphBuilder.wordsScreen() {
    composable<WordsRoute> {
        WordsRoute()
    }
}
