package com.example.define.feature.dictionary

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
internal fun SearchRoute(
    modifier: Modifier = Modifier,
) {
    SearchScreen(modifier = modifier)
}

@Composable
internal fun SearchScreen(modifier: Modifier) {
    Text("Search screen")
}