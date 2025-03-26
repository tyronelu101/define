package com.example.define.feature.dictionary

import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
internal fun SearchRoute(
    viewModel: SearchViewModel = hiltViewModel(),
    modifier: Modifier = Modifier,
) {
    SearchScreen(modifier = modifier)
}

@Composable
internal fun SearchScreen(modifier: Modifier) {


//    SearchBar { }()

}

@Composable
private fun SearchBar() {

}

@Composable
private fun SearchResult() {

}