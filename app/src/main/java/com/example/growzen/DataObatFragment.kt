package com.example.growzen


import android.content.Intent
import android.os.Bundle

import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.lifecycle.ViewModelProvider
import com.example.growzen.Entity.DataObat
import com.example.growzen.ViewModel.DataObatViewModel


import androidx.navigation.fragment.findNavController
import com.example.growzen.Database.DatabaseNote
import com.example.growzen.Repository.DataObatRepository
import com.example.growzen.Utils.DataObatViewModelFactory


class DataObatFragment : Fragment() {

    private lateinit var obatViewModel: DataObatViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_data_obat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val repository = DataObatRepository(DatabaseNote.getDatabase(requireContext()).obatDao())
        obatViewModel = ViewModelProvider(this, DataObatViewModelFactory(repository)).get(DataObatViewModel::class.java)


        val next = view.findViewById<Button>(R.id.btn_next)

        next.setOnClickListener {
            try {
                val jenisObat =
                    view.findViewById<Spinner>(R.id.ED_JenisObat).selectedItem.toString()
                val namaObat = view.findViewById<EditText>(R.id.ED_NamaObat).text.toString()
                val stokObatText = view.findViewById<EditText>(R.id.ED_Stok).text.toString()
                val dosis = view.findViewById<EditText>(R.id.ED_Dosis).text.toString()


//                val stokObat = stokObatText.toIntOrNull() ?: 0

                // Validasi stokObat agar tidak terjadi NumberFormatException
                val stokObat = if (stokObatText.isNotEmpty()) stokObatText.toInt() else 0

                val obatEntity = DataObat(jenisObat, namaObat, stokObat, dosis)

                obatViewModel.insert(obatEntity)

//                val intent = Intent(requireContext(), TambahObat2Activity::class.java)
//                startActivity(intent)

            } catch (e: Exception) {
                e.printStackTrace()
            }
            val intent = Intent(requireContext(), TambahObat2Activity::class.java)
            startActivity(intent)
        }

//        next.setOnClickListener {
//
//            val jenisObat = view.findViewById<Spinner>(R.id.ED_JenisObat).selectedItem.toString()
//            val namaObat = view.findViewById<EditText>(R.id.ED_NamaObat).text.toString()
//            val stokObat = view.findViewById<EditText>(R.id.ED_Stok).text.toString().toInt()
//            val dosis = view.findViewById<EditText>(R.id.ED_Dosis).text.toString()
//
//
//
//            val obatEntity = DataObat(jenisObat, namaObat, stokObat, dosis)
//
//            obatViewModel.insert(obatEntity)
//
//
//
////            val intent = Intent(requireContext(), TambahObat2Activity::class.java)
////            startActivity(intent)
//
//        }
    }

}