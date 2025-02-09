package com.example.define.core.data.repository

import com.example.define.core.datastore.UserPreferencesDataSource
import com.example.define.core.models.UserPreferencesModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class DefaultUserPreferencesRepository @Inject constructor(private val userPreferencesDataSource: UserPreferencesDataSource) :
    UserPreferenceRepository {

    override val userPreferencesModel: Flow<UserPreferencesModel> = userPreferencesDataSource.userData

    override suspend fun setSourceLanguage(src: String) {
        userPreferencesDataSource.setSourceLanguage(src)
    }

    override suspend fun setTargetLanguage(target: String) {
        userPreferencesDataSource.setTargetLanguage(target)
    }
}