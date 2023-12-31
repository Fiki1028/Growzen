package com.example.growzen.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//@Entity(tableName = "dataobat")
//data class DataObat(
//    @PrimaryKey(autoGenerate = true)
//    @ColumnInfo(name = "id")
//    val id :Int = 0,
//    @ColumnInfo(name = "namaObat")
//    val namaObat :String,
//    @ColumnInfo(name = "jenisObat")
//    val jenisObat :String,
//    @ColumnInfo(name = "dosis")
//    val dosis :String,
//    @ColumnInfo(name = "stok")
//    val stok :Int = 0
//)

// ObatEntity.kt
@Entity(tableName = "dataobat")
data class DataObat(
    val jenisObat: String,
    val namaObat: String,
    val stokObat: Int,
    val dosis: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}


