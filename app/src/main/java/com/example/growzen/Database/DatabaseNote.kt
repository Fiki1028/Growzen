package com.example.growzen.Database

import android.content.Context
import androidx.room.Database

import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.growzen.Entity.DataObat
import com.example.growzen.Entity.WaktuObat


//@Database(entities = [DataObat::class,WaktuObat::class], version = 1, exportSchema = false)
//abstract class DatabaseNote : RoomDatabase() {
//    abstract fun dao(): Dao
//
//    companion object {
//        private const val DB_NAME = "database.db"
//        @Volatile
//        private var instance: DatabaseNote? = null
//        private val LOCK = Any()
//
//        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
//            instance ?: buildDatabase(context).also {
//                instance = it
//            }
//        }
//
//        private fun buildDatabase(context: Context) = Room.databaseBuilder(
//            context.applicationContext,
//            DatabaseNote::class.java,
//            DB_NAME
//        ).build()
////            .fallbackToDestructiveMigration()
//
//    }
//}



@Database(entities = [DataObat::class], version = 1, exportSchema = false)
abstract class DatabaseNote : RoomDatabase() {
    abstract fun obatDao(): Dao

    companion object {
        @Volatile
        private var INSTANCE: DatabaseNote? = null

        fun getDatabase(context: Context): DatabaseNote {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DatabaseNote::class.java,
                    "obat_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }

}