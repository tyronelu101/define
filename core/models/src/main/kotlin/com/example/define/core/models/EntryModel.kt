package com.example.define.core.models

data class EntryModel(
    val word: String,
    val definitions: List<DefinitionModel>,
    val dictionary: DictionaryModel
)
