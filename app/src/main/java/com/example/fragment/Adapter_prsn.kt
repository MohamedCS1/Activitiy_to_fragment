package com.example.fragment

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.Pojo.Prsn_Model

class Adapter_prsn: RecyclerView.Adapter<Adapter_prsn.Holder_Prsn>() {

    private var arraylist = arrayListOf<Prsn_Model>()

    private var listerner:SetOnClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder_Prsn {

        return Holder_Prsn(LayoutInflater.from(parent.context).inflate(R.layout.card_prsn,parent,false))

    }

    override fun onBindViewHolder(holder: Holder_Prsn, position: Int) {

        holder.tv_name.text = arraylist[position].name
        holder.tv_prnm.text = arraylist[position].prnm
        holder.tv_age.text = arraylist[position].age.toString()
        holder.itemView.setOnClickListener {
            listerner!!.OnItemClick(arraylist[position])
        }

    }

    override fun getItemCount(): Int {
        return arraylist.size
    }


    class Holder_Prsn(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val tv_name = itemView.findViewById<TextView>(R.id.tv_name)

        val tv_prnm = itemView.findViewById<TextView>(R.id.tv_prnm)

        val tv_age = itemView.findViewById<TextView>(R.id.tv_age)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(ArrayList:ArrayList<Prsn_Model>)
    {
        this.arraylist = ArrayList
        notifyDataSetChanged()
    }

    fun set_listener(listerner:SetOnClickListener)
    {
        this.listerner = listerner
    }

}