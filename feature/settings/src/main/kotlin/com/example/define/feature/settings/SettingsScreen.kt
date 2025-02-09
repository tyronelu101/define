package com.example.define.feature.settings

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.serialization.Serializable


@Serializable
object SettingsRoute

@Composable
internal fun SettingsRoute(
    modifier: Modifier = Modifier,
    viewModel: SettingsViewModel = hiltViewModel()
) {
    SettingsScreen(modifier = modifier)
}

@Composable
internal fun SettingsScreen(modifier: Modifier) {

    Text(text = "Settings screen")
}