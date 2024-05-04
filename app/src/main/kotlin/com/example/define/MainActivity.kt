package com.example.define

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.define.ui.DefineApp
import com.example.define.ui.theme.DefineTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DefineTheme {
                DefineApp()
            }
        }
    }
}