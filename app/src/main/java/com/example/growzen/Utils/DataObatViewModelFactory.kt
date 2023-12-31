package com.example.growzen.Utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.growzen.Repository.DataObatRepository
import com.example.growzen.ViewModel.DataObatViewModel

//package com.example.growzen.Utils
//
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.ViewModelProvider
//import com.example.growzen.Repository.DataObatRepository
//
//
class DataObatViewModelFactory(private val repository: DataObatRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DataObatViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DataObatViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}