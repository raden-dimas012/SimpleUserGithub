package com.example.simplegithubuser

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class DataAdapter(
    private  val context : Context,
    private val listItems: ArrayList<Data>,
    private val listener: (Data) -> Unit
) : RecyclerView.Adapter<DataAdapter.DataViewHolder>() {
    class DataViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val imageSrc : ImageView = view.findViewById(R.id.img_avatar)
        private val nama : TextView = view.findViewById(R.id.tv_nama)
        private val location : TextView = view.findViewById(R.id.tv_location)
        private val company : TextView = view.findViewById(R.id.tv_company)

        @SuppressLint("SetTextI18n")
        fun bindView (data : Data, listener: (Data) -> Unit) {
            imageSrc.setImageResource(data.avatar!!)
            nama.text = data.nama
            location.text = "Location : ${data.location}"
            company.text = "Company : ${data.company}"
            itemView.setOnClickListener{listener(data)}
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder
            = DataViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view,parent,false))

    override fun getItemCount(): Int = listItems.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bindView(listItems[position],listener)
    }
}
