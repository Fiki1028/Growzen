package com.example.growzen.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.growzen.Entity.DataObat
import com.example.growzen.R
import androidx.recyclerview.widget.DiffUtil
import com.example.growzen.Model.Obat


//class DataObatAdapter : ListAdapter<DataObat, DataObatAdapter.DataObatViewHolder>(DataObatDiffCallback()) {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataObatViewHolder {
//        val view = LayoutInflater.from(parent.context)
//            .inflate(R.layout.item_obat, parent, false)
//        return DataObatViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: DataObatViewHolder, position: Int) {
//        val dataObat = getItem(position)
//        holder.bind(dataObat)
//    }
//
//    fun submitList(dataObatList: DataObat) {
//        submitList(dataObatList)
//    }
//
//
//
//    class DataObatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        private val tvNamaObat: TextView = itemView.findViewById(R.id.tvNamaObat)
//        private val tvJenis: TextView = itemView.findViewById(R.id.tvWaktu)
//        private val tvDosis: TextView = itemView.findViewById(R.id.tvDosis)
//        private val tvStok: TextView = itemView.findViewById(R.id.tvStok)
//
//
//        fun bind(dataObat: DataObat) {
//            tvNamaObat.text = dataObat.namaObat
//            tvJenis.text = dataObat.jenisObat
//            tvDosis.text = dataObat.dosis
//            tvStok.text = dataObat.stok.toString()
//        }
//    }
//
//    private class DataObatDiffCallback : DiffUtil.ItemCallback<DataObat>() {
//        override fun areItemsTheSame(oldItem: DataObat, newItem: DataObat): Boolean {
//            return oldItem.id == newItem.id
//        }
//
//        override fun areContentsTheSame(oldItem: DataObat, newItem: DataObat): Boolean {
//            return oldItem == newItem
//        }
//    }
//}




class DataObatAdapter(private var obatList: List<DataObat>) :
    RecyclerView.Adapter<DataObatAdapter.ObatViewHolder>() {

    class ObatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewJenis: TextView = itemView.findViewById(R.id.tvWaktu)
        val textViewNama: TextView = itemView.findViewById(R.id.tvNamaObat)
        val textViewStok: TextView = itemView.findViewById(R.id.tvStok)
        val textViewDosis: TextView = itemView.findViewById(R.id.tvDosis)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ObatViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_obat, parent, false)
        return ObatViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ObatViewHolder, position: Int) {
        val currentItem = obatList[position]

        holder.textViewJenis.text = currentItem.jenisObat
        holder.textViewNama.text = currentItem.namaObat
        holder.textViewStok.text = currentItem.stokObat.toString()
        holder.textViewDosis.text = currentItem.dosis
    }

    override fun getItemCount() = obatList.size

    fun setObatList(newObatList: List<DataObat>) {
        obatList = newObatList
        notifyDataSetChanged()
    }

}