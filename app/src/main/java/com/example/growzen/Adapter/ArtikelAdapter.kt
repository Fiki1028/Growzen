package com.example.growzen.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.growzen.Model.ModelsArtikel
import com.example.growzen.R

class ArtikelAdapter (
    private val context: Context,
    private val modelsArtikelList: List<ModelsArtikel>,
    private val titles: Array<String>,
    private val modelsArtikelListener: (ModelsArtikel) -> Unit

): RecyclerView.Adapter<ArtikelAdapter.ArtikelViewHolder>() {

    inner class ArtikelViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgArtikel: ImageView = view.findViewById(R.id.img_artikel)
        val judulArtikel: TextView = view.findViewById(R.id.tv_judul_artikel)

        fun bindView(modelsArtikel: ModelsArtikel, listener: (ModelsArtikel) -> Unit) {
            imgArtikel.setImageResource(modelsArtikel.imgArtikel)
            judulArtikel.text = titles[modelsArtikel.titleIndex]

            // Set OnClickListener untuk item
            itemView.setOnClickListener {
                listener(modelsArtikel)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtikelViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return ArtikelViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArtikelViewHolder, position: Int) {
        holder.bindView(modelsArtikelList[position], modelsArtikelListener)
    }

    override fun getItemCount(): Int = modelsArtikelList.size

}

