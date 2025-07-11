package com.mk.screen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterList(
    private val stockList: List<StockList>
) : RecyclerView.Adapter<AdapterList.ViewHolderClass>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolderClass {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_content,parent,false)
        return ViewHolderClass(itemView)
    }

    override fun onBindViewHolder(
        holder: ViewHolderClass,
        position: Int
    ) {
        val item = stockList[position]
        holder.apply {
            holder.productName.text = item.product
            holder.produced.text = item.produced
            holder.sold.text = item.sold
            holder.availabled.text = item.available
            holder.deadStock.text = item.dead
        }
    }

    override fun getItemCount(): Int {
        return stockList.size
    }

    inner class ViewHolderClass(itemView : View) : RecyclerView.ViewHolder(itemView){
        val productName: TextView = itemView.findViewById(R.id.productName)
        val produced: TextView = itemView.findViewById(R.id.produced)
        val sold: TextView = itemView.findViewById(R.id.sold)
        val availabled: TextView = itemView.findViewById(R.id.available)
        val deadStock: TextView = itemView.findViewById(R.id.deadStock)
    }



}