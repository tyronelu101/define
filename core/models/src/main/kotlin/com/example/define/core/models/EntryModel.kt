package com.example.define.core.models

data class EntryModel(
    val word: String,
    val definition: List<String>,
    val pronunciation: List<String>,
    val wordSource: DictionaryModel
)
