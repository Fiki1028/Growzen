package com.example.growzen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.growzen.Adapter.ArtikelAdapter
import com.example.growzen.Model.ModelsArtikel

class ArtikelActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artikel)

        val titles = resources.getStringArray(R.array.titles)

        val artikelList = generateDummyData(titles.size)

        val artikelAdapter = ArtikelAdapter(this, artikelList, titles) { modelsArtikel ->
            val intent = Intent(this, IsiArtikellActivity::class.java)
            intent.putExtra("modelsArtikel", modelsArtikel)
            startActivity(intent)
       }
        val recyclerView = findViewById<RecyclerView>(R.id.rv_artikel)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = artikelAdapter

    }

    private fun generateDummyData(size: Int): List<ModelsArtikel> {
        val dummyList = mutableListOf<ModelsArtikel>()
        val images = intArrayOf(
            R.drawable.artikel1,
            R.drawable.artikel2,
            R.drawable.artikel3,
            R.drawable.artikel4
        )

        for (i in 0 until size) {
            dummyList.add(
                ModelsArtikel(
                    imgArtikel = images[i % images.size],
                    titleIndex = i,
                    descriptionIndex = i
                )
            )
        }
        return dummyList
    }
}