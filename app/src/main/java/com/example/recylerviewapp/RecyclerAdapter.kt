package com.example.recylerviewapp

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(
        private var list: List<Int>,
        private val onClick: (index:Int)->Unit
    ):RecyclerView.Adapter<RecyclerAdapter.ViewHolder>()   {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.textView.text = list[position].toString()

        holder.textView.setOnClickListener {
            if(holder.adapterPosition>-1){
                onClick(holder.adapterPosition)
            }
        }

        holder.buttonDel.setOnClickListener {
            if(holder.adapterPosition>-1){
                onClick(holder.adapterPosition)
            }
        }


    }

    override fun getItemCount(): Int {
        return list.size;
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val textView = itemView.findViewById<TextView>(R.id.textView)
        val buttonDel =  itemView.findViewById<Button>(R.id.buttonDel)
    }

    public fun updateList(updatedList:List<Int>){
        list = updatedList
    }


}