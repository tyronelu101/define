//package com.example.define.feature.setup
//
//import android.util.Log
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.material3.FloatingActionButton
//import androidx.compose.material3.Icon
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Surface
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.hilt.navigation.compose.hiltViewModel
//import androidx.lifecycle.compose.collectAsStateWithLifecycle
//
//@Composable
//internal fun SetupRoute(
//    modifier: Modifier = Modifier,
//    viewModel: SetupViewModel = hiltViewModel()
//) {
//    val supportedLanguages: List<SupportedLanguageItemUI> by viewModel.supportedLanguages.collectAsStateWithLifecycle()
//
//    SetupScreen(
//        supportedLanguages = supportedLanguages,
//        onLanguageClick = { language -> viewModel.selectLanguage(language) },
//        onNextClick = { Log.i("SetupScreen", "Going to next screen") },
//        modifier = modifier
//    )
//}
//
//@Composable
//private fun SetupScreen(
//    supportedLanguages: List<SupportedLanguageItemUI>,
//    onLanguageClick: (language: String) -> Unit,
//    onNextClick: () -> Unit,
//    modifier: Modifier = Modifier
//) {
//
//    Log.i("SetupScreen", "SetupScreen composing")
//
//    Scaffold(floatingActionButton = {
//        FloatingActionButton(onClick = onNextClick) {
//            Text(text = "hi")
//        }
//    }) { padding ->
//        LanguageList(
//            languages = supportedLanguages,
//            onItemClick = onLanguageClick,
//            modifier = modifier.padding(padding)
//        )
//
//    }
//}
//
//@Composable
//fun LanguageList(
//    languages: List<SupportedLanguageItemUI>,
//    onItemClick: (language: String) -> Unit,
//    modifier: Modifier
//) {
//    Surface(modifier = modifier.padding(16.dp), color = Color.Gray) {
//        LazyColumn(modifier = modifier.fillMaxWidth()) {
//            items(languages, key = { item ->
//                item.language
//            }) { language ->
//                LanguageItem(
//                    item = language,
//                    onClick = onItemClick,
//                    modifier = modifier
//                )
//            }
//        }
//    }
//}
//
//@Composable
//fun LanguageItem(
//    item: SupportedLanguageItemUI,
//    onClick: (language: String) -> Unit,
//    modifier: Modifier
//) {
//    Log.i("SetupScreen", "LanguageItem composing")
//    Row(modifier = modifier
//        .padding(16.dp)
//        .clickable(onClick = { onClick(item.language) })
//    ) {
//        Icon(
//            painter = painterResource(id = item.iconRes),
//            contentDescription = "${item.language}_flag",
//        )
//        Text(text = item.language)
//        if (item.isSelected) {
//            Icon(
//                painter = painterResource(id = R.drawable.check_24dp),
//                contentDescription = "Check mark"
//            )
//        }
//    }
//}
//
//@Preview
//@Composable
//private fun LanguageItemPreview() {
//    LanguageItem(
//        item = SupportedLanguageItemUI(
//            iconRes = R.drawable.flag_usa,
//            "Japanese",
//            dictionarySource = emptyList(),
//            isSelected = false
//        ),
//        onClick = {}, modifier = Modifier
//    )
//}