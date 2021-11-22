package com.kris.azlogisticpretest.Tugas2.Login.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kris.azlogisticpretest.R
import com.kris.azlogisticpretest.Tugas2.Login.detailBarang.DetailBarangActivity
import com.kris.azlogisticpretest.Tugas2.Login.models.Barang
import com.squareup.picasso.Picasso
import java.security.AccessController.getContext

class BarangAdapter(
    private var barang:ArrayList<Barang.Database>,
    val listener: OnAdapterListener

) : RecyclerView.Adapter<BarangAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_adapter_barang, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data =barang[position]
        holder.namaBarang?.text =data.title
        Picasso.with(getContext()).load(data.url).fit().into(holder.gambarBarang)

        holder.itemView.setOnClickListener {
            listener.getInfo( data )
        }
    }

    override fun getItemCount()= barang.size

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val namaBarang: TextView? = view.findViewById(R.id.tvNamaBarang)
        val gambarBarang: ImageView? = view.findViewById(R.id.ivProduct)
    }

    fun setData(data: List<Barang.Database>){
        barang.clear()
        barang.addAll(data)
        notifyDataSetChanged()
    }

    interface OnAdapterListener{
        fun getInfo(database: Barang.Database)
    }
}