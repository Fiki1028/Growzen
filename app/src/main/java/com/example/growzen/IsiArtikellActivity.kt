package com.example.growzen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.growzen.Model.ModelsArtikel

class IsiArtikellActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_isi_artikell)

        val imageViewDetail = findViewById<ImageView>(R.id.imageViewDetail)
        val textViewJudulDetail = findViewById<TextView>(R.id.textViewJudulDetail)
        val textViewDeskripsiDetail = findViewById<TextView>(R.id.textViewDeskripsiDetail)

        // Mendapatkan data yang dikirim dari intent
//        val modelsArtikel = intent.getParcelableExtra<ModelsArtikel>("modelsArtikel")
        val modelsArtikel: ModelsArtikel? = intent.getParcelableExtra("modelsArtikel")

        // Set data ke elemen UI
        modelsArtikel?.let {
            imageViewDetail.setImageResource(it.imgArtikel)
            textViewJudulDetail.text = resources.getStringArray(R.array.titles)[it.titleIndex]
            textViewDeskripsiDetail.text = resources.getStringArray(R.array.descriptions)[it.descriptionIndex]
        }

    }
}