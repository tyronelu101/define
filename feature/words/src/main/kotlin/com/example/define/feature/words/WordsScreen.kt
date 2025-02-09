package com.example.define.feature.words

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
internal fun WordsRoute(
    modifier: Modifier = Modifier,
    viewModel: WordsScreenViewModel = hiltViewModel()
) {

    WordsScreen(modifier = modifier)

}

@Composable
internal fun WordsScreen(modifier: Modifier) {
    Text(text = "Word screen")
}

@Preview
@Composable
internal fun WordsScreenPreview() {

    WordsScreen(modifier = Modifier)
}
