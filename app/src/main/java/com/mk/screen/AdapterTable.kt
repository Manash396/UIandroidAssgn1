package com.mk.screen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterTable (
    private val stockList: List<StockTable>
) : RecyclerView.Adapter<AdapterTable.ViewHolder>(){

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvDate: TextView = itemView.findViewById(R.id.tvDate)
        val tvProduced: TextView = itemView.findViewById(R.id.tvProduced)
        val tvInStock: TextView = itemView.findViewById(R.id.tvInStock)

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
       val itemView = LayoutInflater.from(parent.context).inflate(R.layout.table_content,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val stock = stockList[position]
        holder.apply {
            tvDate.text = stock.date
            tvProduced.text = stock.produced
            tvInStock.text = stock.inStock
        }
    }

    override fun getItemCount(): Int {
        return stockList.size
    }



}