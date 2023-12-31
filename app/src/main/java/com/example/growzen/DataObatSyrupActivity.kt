package com.example.growzen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class DataObatSyrupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_obat_syrup)

        val rifampicin = findViewById<Button>(R.id.btn_tablet_1)
        rifampicin.setOnClickListener {
            val intent = Intent(this, Rifampicin::class.java)
            startActivity(intent)
        }
        val omeprazol = findViewById<Button>(R.id.btn_tablet_2)
        omeprazol.setOnClickListener {
            val intent = Intent(this, Omeprazol::class.java)
            startActivity(intent)
        }
        val asamfolat = findViewById<Button>(R.id.btn_tablet_3)
        asamfolat.setOnClickListener {
            val intent = Intent(this, Asamfolat::class.java)
            startActivity(intent)
        }
        val paracitamol = findViewById<Button>(R.id.btn_tablet_4)
        paracitamol.setOnClickListener {
            val intent = Intent(this, Paracitamol::class.java)
            startActivity(intent)
        }

    }
}