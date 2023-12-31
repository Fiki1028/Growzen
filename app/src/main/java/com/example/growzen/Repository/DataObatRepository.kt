package com.example.growzen.Repository

import androidx.lifecycle.LiveData
import com.example.growzen.Database.Dao
import com.example.growzen.Database.DatabaseNote
import com.example.growzen.Entity.DataObat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

//class DataObatRepository (
//
//    val database:DatabaseNote
//    ) {
//        fun getAllDataObat(): LiveData<List<DataObat>> = database.dao().getAllDataObat()
//        fun getDataObatByJenis(jenis: String):LiveData<DataObat> = database.dao().getDataObatByJenis(jenis)
//        suspend fun insertDataObat(dataObat:DataObat) = database.dao().insertDataObat(dataObat)
//
//}


class DataObatRepository(private val obatDao: Dao) {

    val allObat: LiveData<List<DataObat>> = obatDao.getAllObat()

//    suspend fun insert(obat: DataObat) {
//        obatDao.insert(obat)
//    }
    suspend fun insert(obat: DataObat) {
        withContext(Dispatchers.IO) {
            obatDao.insert(obat)
        }
    }

}

