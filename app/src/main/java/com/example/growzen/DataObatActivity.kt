package com.example.growzen

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Spinner
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.growzen.Adapter.DataObatAdapter
import com.example.growzen.Database.DatabaseNote
import com.example.growzen.Entity.DataObat
import com.example.growzen.ViewModel.DataObatViewModel
import com.example.growzen.databinding.ActivityDataObatBinding


//class DataObatActivity : AppCompatActivity() {
//
////    private lateinit var viewModel: DataObatViewModel
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_data_obat)
////
////
//////        val jenis = intent.getStringExtra("JENIS") ?: ""
//////
//////        viewModel = ViewModelProvider(this)[DataObatViewModel::class.java]
//////
//////        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
//////        val adapter = DataObatAdapter()
//////        recyclerView.adapter = adapter
//////
//////        viewModel.getDataObatByJenis(jenis).observe(this, Observer { dataObatList ->
//////            adapter.submitList(dataObatList)
//////        })
//    }
//}
//
//
//
//
////class DataObatActivity : AppCompatActivity() {
////
////    private lateinit var binding: ActivityDataObatBinding
////    private lateinit var viewModel: DataObatViewModel
////
////    override fun onCreate(savedInstanceState: Bundle?) {
////        super.onCreate(savedInstanceState)
////
////
////        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_obat)
////        binding.lifecycleOwner = this
////
////        val jenis = intent.getStringExtra("JENIS") ?: ""
////
////        viewModel = ViewModelProvider(this, ViewModelFactory(repository = DataObatRepository(database = DatabaseNote(this)))).get(DataObatViewModel::class.java)
////
////
////        binding.viewModel = viewModel
////
////        val adapter = DataObatAdapter()
////        binding.recyclerView.adapter = adapter
////
////        viewModel.getDataObatByJenis(jenis).observe(this, Observer { dataObatList ->
////            dataObatList?.let {
////                adapter.submitList(it)
////            }
////        })
////
////    }
////
////
////}

class DataObatActivity : AppCompatActivity() {

    private lateinit var obatViewModel: DataObatViewModel
    private lateinit var binding: ActivityDataObatBinding
    private lateinit var adapter: DataObatAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDataObatBinding.inflate(layoutInflater)  // Update this line
        setContentView(binding.root)  // Update this line

        obatViewModel = ViewModelProvider(this).get(DataObatViewModel::class.java)

        val adapter = DataObatAdapter(emptyList())
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.adapter = adapter

        obatViewModel.allObat.observe(this, { obatList ->
            adapter.setObatList(obatList)
        })
    }
}