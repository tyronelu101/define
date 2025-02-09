package com.example.define.feature.dictionary

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.define.core.models.UserPreferencesModel
import com.example.define.feature.dictionary.types.LanguageSelectionType
import com.example.define.ui.icons.DefineIcons
import java.util.Locale

@Composable
internal fun HomeRoute(
    modifier: Modifier = Modifier,
    viewModel: HomeScreenViewModel = hiltViewModel(),
    onSearchClick: () -> Unit,
    onLanguageClick: (type: LanguageSelectionType) -> Unit
) {
    val userPreferences by viewModel.languagePreferences.collectAsStateWithLifecycle()

    HomeScreen(
        //States
        userPreferences = userPreferences,
        //Events
        onClick = onSearchClick,
        onLanguageClick = onLanguageClick,
        modifier = modifier

    )
}

@Composable
internal fun HomeScreen(
    userPreferences: UserPreferencesModel,
    onClick: () -> Unit = {},
    onLanguageClick: (type: LanguageSelectionType) -> Unit,
    modifier: Modifier
) {
    Column(modifier = modifier) {
        InputField(
            modifier = modifier,
            onClick = onClick,
        )
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            val sourceLanguageName = Locale(userPreferences.srcLanguage).displayName
            val targetLanguageName = Locale(userPreferences.targetLanguage).displayName
            Button(onClick = { onLanguageClick(LanguageSelectionType.SOURCE) }) { Text(text = (sourceLanguageName)) }
            Icon(
                painter = painterResource(DefineIcons.Swap),
                contentDescription = stringResource(R.string.language_swap_content_description)
            )
            Button(onClick = { onLanguageClick(LanguageSelectionType.TARGET) }) { Text(text = (targetLanguageName)) }
        }
        BottomInput(modifier = modifier)
    }
}

@Composable
private fun InputField(
    modifier: Modifier,
    onClick: () -> Unit,
) {
    Card(
        modifier = modifier
            .clickable { onClick() }
            .fillMaxWidth()
            .fillMaxHeight(0.60f),
    ) {

        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(modifier = modifier.padding(8.dp), text = "Enter text")
            Text(modifier = modifier
                .clickable { Log.i("Test", "AI Clicked") }
                .padding(8.dp), text = "AI")
        }
    }
}


@Composable
private fun BottomInput(modifier: Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                modifier = modifier.size(32.dp),
                painter = painterResource(id = DefineIcons.Camera),
                contentDescription = "Camera"
            )
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                modifier = modifier.size(32.dp),
                painter = painterResource(id = DefineIcons.Pen),
                contentDescription = "Draw"
            )
        }
        IconButton(modifier = modifier, onClick = { /*TODO*/ }) {
            Icon(
                modifier = modifier.size(32.dp),
                painter = painterResource(id = DefineIcons.Voice),
                contentDescription = "Voice"
            )
        }
    }
}