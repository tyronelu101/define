package com.example.define.ui

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.define.navigation.DefineNavHost
import com.example.define.ui.icons.DefineIcons

@Composable
fun DefineApp() {

    // A surface container using the 'background' color from the theme
    Surface(
        modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
    ) {
        DefineApp(isOffline = false)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun DefineApp(isOffline: Boolean) {

    val navController = rememberNavController()

    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute by remember {
        derivedStateOf {
            currentBackStackEntry?.destination?.route ?: ""
        }
    }

    Scaffold(topBar = {
        if (currentRoute == "com.example.define.feature.dictionary.navigation.HomeScreen") {
            CenterAlignedTopAppBar(
                title = { Text("Define") },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = ImageVector.vectorResource(DefineIcons.Settings),
                            contentDescription = "Settings"
                        )
                    }
                },
            )
        }

    }) { padding ->
        Log.i("Test", "composing DefineApp.kt")
        Column(modifier = Modifier.padding(padding)) {
            DefineNavHost(navController = navController)
        }
    }
}

@Preview
@Composable
private fun DefineAppPreview() {
    DefineApp()
}