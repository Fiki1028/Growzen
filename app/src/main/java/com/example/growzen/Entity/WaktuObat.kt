package com.example.growzen.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "waktuobat")
data class WaktuObat(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    val waktu: String
)
