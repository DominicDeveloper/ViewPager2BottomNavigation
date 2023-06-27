package com.asadbek.viewpager2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.squareup.picasso.Picasso

class PagerAdapterMy(val list:List<String>,val click: Click):RecyclerView.Adapter<PagerAdapterMy.PagerVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerVH =
       PagerVH(LayoutInflater.from(parent.context).inflate(R.layout.item_rv,parent,false))

    override fun onBindViewHolder(holder: PagerVH, position: Int) {
        val image = holder.itemView.findViewById<ImageView>(R.id.image)
        val btn = holder.itemView.findViewById<FloatingActionButton>(R.id.btn_url)
        btn.setOnClickListener {
            click.onClick(list[position])
        }
        Picasso.get().load(list[position]).into(image)
    }

    override fun getItemCount(): Int {
        return list.size
    }
    inner class PagerVH(itemView:View):RecyclerView.ViewHolder(itemView)
    interface Click{
        fun onClick(data:String)
    }
}