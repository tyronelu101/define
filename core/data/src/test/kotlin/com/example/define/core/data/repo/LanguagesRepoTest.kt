//package com.example.define.core.data.repo
//
//import model.DictionarySource
//import com.example.define.core.data.repository.SupportedLanguagesRepo
//import com.example.define.core.data.repository.SupportedLanguagesLocalRemoteRepo
//import com.example.define.core.data.FakeDictionaryStreamProvider
//import model.SupportedLanguage
//import kotlinx.coroutines.runBlocking
//import org.junit.Before
//import org.junit.Test
//
//class LanguagesRepoTest {
//
//    private lateinit var repo: SupportedLanguagesRepo
//
//    @Before
//    fun setup() {
//        repo = Defa(FakeDictionaryStreamProvider())
//    }
//
//    @Test
//    fun get_dictionaries_sources() = runBlocking {
//        val expected = listOf(
//            model.SupportedLanguage(
//                "Japanese", dictionaries =
//                listOf(
//                    model.DictionarySource(
//                        name = "jmdic",
//                        language = "english",
//                        type = "dictionary",
//                        src = "jmdict-eng-3.5.0.json"
//                    )
//                )
//            ),
//        )
//
//        val result = repo.getSupportedLanguages()
//
//        assert(result == expected)
//    }
//}