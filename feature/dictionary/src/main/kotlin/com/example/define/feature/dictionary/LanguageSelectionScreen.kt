package com.example.define.feature.dictionary

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.define.ui.icons.DefineIcons

@Composable
internal fun LanguageRoute(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: LanguageScreenViewModel = hiltViewModel(),
) {
    val supportedLanguages by viewModel.searchResults.collectAsState()

    Log.i("Test", "Search result is ${supportedLanguages}")
    LanguageScreen(
        languageItems = supportedLanguages,
        onBackClick = onBackClick,
        onItemClick = {
            viewModel.onLanguageSelected(it)
            onBackClick()
        },
        onSearch = viewModel::onSearch,
        modifier = modifier,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun LanguageScreen(
    languageItems: List<SupportedLanguageItem>,
    onBackClick: () -> Unit,
    onItemClick: (languageCode: String) -> Unit,
    onSearch: (query: String) -> Unit,
    modifier: Modifier = Modifier,
) {
    var isSearchClicked by remember {
        mutableStateOf(false)
    }

    var text by rememberSaveable { mutableStateOf("") }

    Scaffold(topBar = {
        Log.i("Test", "Composing scaffold")
        CenterAlignedTopAppBar(
            title = { Text("") },
            navigationIcon = {
                IconButton(onClick = {
                    if (isSearchClicked) {
                        isSearchClicked = false
                    } else {
                        onBackClick()
                    }
                }) {
                    Icon(
                        imageVector = ImageVector.vectorResource(DefineIcons.Back),
                        contentDescription = "Back"
                    )
                }
            },
            actions = {
                if (!isSearchClicked) {
                    IconButton(onClick = { isSearchClicked = !isSearchClicked }) {
                        Icon(
                            imageVector = ImageVector.vectorResource(DefineIcons.Search),
                            contentDescription = "Search"
                        )
                    }
                } else {
                    OutlinedTextField(leadingIcon = {
                        Icon(
                            imageVector = ImageVector.vectorResource(DefineIcons.Search),
                            contentDescription = "Search"
                        )
                    },
                        value = text,
                        onValueChange = {
                            text = it
                            onSearch(text)
                        },
                        modifier = modifier.padding(8.dp),
                        placeholder = { Text(text = "Search") })
                }

            },
        )
    }) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            LazyColumn {
                items(items = languageItems, key = { languageItem ->
                    when (languageItem) {
                        is SupportedLanguageItem.Header -> languageItem.text
                        is SupportedLanguageItem.Language -> languageItem.languageCode
                    }
                }) {
                    LanguageItem(item = it, onItemClick = onItemClick)
                }
            }
        }
    }
}

@Composable
private fun LanguageItem(
    item: SupportedLanguageItem,
    onItemClick: (languageCode: String) -> Unit,
    modifier: Modifier = Modifier,
) {
    when (item) {
        is SupportedLanguageItem.Header -> {
            Text(item.text)
        }

        is SupportedLanguageItem.Language -> {
            Row(
                modifier = modifier
                    .padding(8.dp)
                    .fillMaxWidth()
                    .clickable { onItemClick(item.languageCode) },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(item.languageName)
                if (item.selected) {
                    Icon(
                        modifier = modifier.background(
                            color = Color.DarkGray
                        ),
                        painter = painterResource(id = DefineIcons.Check),
                        contentDescription = stringResource(R.string.search),
                    )
                }
            }
        }
    }
}

//@Composable
//@Preview
//private fun LanguageScreenPreview() {
//    LanguageRoute()
//}

@Composable
@Preview
private fun LanguageItemPreview() {

    Column {
        LanguageItem(item = SupportedLanguageItem.Header("Recent"), {})
        LanguageItem(item = SupportedLanguageItem.Language(
            "EN", "English", false, dataSource = LanguageSource.LOCAL

        ), {})
        LanguageItem(item = SupportedLanguageItem.Header("Languages"), {})
        LanguageItem(item = SupportedLanguageItem.Language(
            "JP", "Japanese", true, dataSource = LanguageSource.REMOTE
        ), {})

    }
}