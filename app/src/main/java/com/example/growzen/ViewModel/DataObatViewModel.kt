package com.example.growzen.ViewModel


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.growzen.Entity.DataObat
import com.example.growzen.Model.Obat
import com.example.growzen.Repository.DataObatRepository
import kotlinx.coroutines.launch

class DataObatViewModel(private val repository: DataObatRepository) : ViewModel() {

    val allObat = repository.allObat

//    fun insert(obat: DataObat) = viewModelScope.launch {
//        repository.insert(obat)
//    }
    fun insert(obat: DataObat) = viewModelScope.launch {
        try {
            repository.insert(obat)
        } catch (e: Exception) {
            e.printStackTrace()
            // Handle or log the exception accordingly
        }
    }
}

