import android.util.Log
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.define.core.data.repository.DefaultDictionaryRepository
import com.example.define.core.data.repository.DictionaryRepository
import com.example.define.core.database.DefineDatabase
import com.example.dictionary_loaders.jp.jmdict.JMdictDeserializer
import com.example.dictionary_loaders.jp.jmdict.JMdictLoader
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class JMdictLoaderTest {

    private lateinit var loader: JMdictLoader
    private lateinit var deserializer: JMdictDeserializer
    private lateinit var db: DefineDatabase
    private lateinit var repo: DictionaryRepository

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<android.content.Context>()
        db = Room.inMemoryDatabaseBuilder(context, DefineDatabase::class.java).build()
        repo = DefaultDictionaryRepository(
            db.dictionaryDao(),
            db.entryDao(),
            db.definitionDao(),
            db.pronunciationDao()
        )

        val inputStream = context.assets.open("jmdict-eng-3.6.1.json")
        deserializer = JMdictDeserializer(inputStream)

//        loader = JMdictLoader(repo, deserializer, UnconfinedTestDispatcher())
    }

    //runTest uses StandardTestDispatcher by default
    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun loaderInsertsJMdictDictionaryAndEntries() = runTest(UnconfinedTestDispatcher()) {
        loader.load()
        val dictionaries = repo.getAllDictionaries()

        assert(dictionaries[0].name == "JMDict")
    }
}