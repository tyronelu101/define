package com.example.define.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.define.R
import com.example.define.ui.icons.DefineIcons

enum class DefineDestinations(
    @StringRes val label: Int,
    @DrawableRes val icon: Int,
    @StringRes val contentDescription: Int
) {
    DICTIONARY(R.string.dictionary, DefineIcons.Home, R.string.dictionary),
    WORDS(R.string.words, DefineIcons.Words, R.string.words),
    SETTINGS(R.string.setting, DefineIcons.Settings, R.string.setting)
}

