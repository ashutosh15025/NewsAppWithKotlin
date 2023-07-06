package com.example.wheelseyeassignment2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView


import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MyAdapter(val context: Context, val articles:List<Article>):RecyclerView.Adapter<MyAdapter.MyViewHolder> () {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater : LayoutInflater=LayoutInflater.from(parent.context)
        val view:View = inflater.inflate(R.layout.row_layout,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

      holder.title.text = articles[position].title;
        holder.description.text = articles[position].description;
        Glide.with(holder.itemView)
            .load(articles[position].urlToImage)
            .into(holder.image)
    }

    override fun getItemCount(): Int {
         return articles.size;
    }


class MyViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
    var title = itemView.findViewById<TextView>(R.id.Newstitle);
    var description = itemView.findViewById<TextView>(R.id.Newsdesct);
    var image = itemView.findViewById<ImageView>(R.id.NewsImage);


}}

