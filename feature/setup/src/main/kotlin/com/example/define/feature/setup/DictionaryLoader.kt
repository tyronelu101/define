package com.example.define.feature.setup

import com.example.define.core.data.repository.DefaultDictionaryRepository


abstract class DictionaryLoader(private val dictionaryRepository: DefaultDictionaryRepository) {

    abstract fun loadDictionary()

}

//class DictionaryLoaderManager(listOf: Deserializer)