package com.example.define.core.datastore

import android.util.Log
import androidx.datastore.core.DataStore
import com.example.define.core.datastore.data.UserPreferences
import com.example.define.core.models.UserPreferencesModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject

class UserPreferencesDataSource @Inject constructor(private val userPreferences: DataStore<UserPreferences>) {

    val userData: Flow<UserPreferencesModel> = userPreferences.data.map {
        UserPreferencesModel(srcLanguage = it.sourceLanguage, targetLanguage = it.targetLanguage)
    }

    suspend fun setSourceLanguage(sourceLanguage: String) {
        try {
            userPreferences.updateData { currentPreferences ->
                currentPreferences.toBuilder()
                    .setSourceLanguage(sourceLanguage).build()
            }
        } catch (ioException: IOException) {
            Log.e("DefinePreferences", "Failed to update user preferences", ioException)
        }
    }

    suspend fun setTargetLanguage(targetLanguage: String) {
        try {
            userPreferences.updateData { currentPreferences ->
                currentPreferences.toBuilder()
                    .setTargetLanguage(targetLanguage).build()
            }
        } catch (ioException: IOException) {
            Log.e("DefinePreferences", "Failed to update user preferences", ioException)
        }
    }

    suspend fun toggleAISearch() {

        try {
//            userPreferences.updateData { currentPreferences ->
//                currentPreferences.toBuilder()
//                    .setSourceLanguage(targetLanguage).build()
//            }
        } catch (ioException: IOException) {
            Log.e("DefinePreferences", "Failed to update user preferences", ioException)
        }
    }


}