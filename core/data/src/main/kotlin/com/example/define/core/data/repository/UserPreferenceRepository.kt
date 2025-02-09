package com.example.define.core.data.repository

import com.example.define.core.models.UserPreferencesModel
import kotlinx.coroutines.flow.Flow

interface UserPreferenceRepository {
    val userPreferencesModel: Flow<UserPreferencesModel>

    suspend fun setSourceLanguage(src: String)
    suspend fun setTargetLanguage(target: String)
}