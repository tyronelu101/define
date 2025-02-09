package com.example.define.core.database.dao

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.define.core.database.DefineDatabase
import com.example.define.core.database.daos.DictionaryDao
import com.example.define.core.database.entities.DictionaryEntity
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DictionaryEntityDaoTest {
    private lateinit var db: DefineDatabase
    private lateinit var dictionaryDao: DictionaryDao

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, DefineDatabase::class.java).build()
        dictionaryDao = db.dictionaryDao()
    }

    @Test
    fun insert_and_get_works() {
        val dictionaryEntity = DictionaryEntity(uuid = "0", name = "Test", language = "Test")
        val expected = DictionaryEntity(uuid = "0", name = "Test", language = "Test")
        dictionaryDao.insert(dictionaryEntity)

        val result = dictionaryDao.get(expected.uuid)

        assert(expected.uuid == result.uuid)
    }
}