package com.lordkajoc.recyclerviewlatihan

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lordkajoc.recyclerviewlatihan.databinding.CardNewsBinding


class RecyclerAdapter(private val listStudent: ArrayList<KumpulanData>) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    //Class ViewHolder
    class ViewHolder(var binding: CardNewsBinding) : RecyclerView.ViewHolder(binding.root)

    //Membuat holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CardNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    //Melakukan penentuan data yang akan ditampilkan pada setiap item/baris
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val (judul, tanggal, kategori, foto) = listStudent[position]
        holder.binding.tvJudul.text = judul
        holder.binding.tvTanggal.text = tanggal
        holder.binding.tvKategori.text = kategori
        holder.binding.imageView.setImageResource(foto)
    }
    override fun getItemCount(): Int {
        return listStudent.size
    }
}