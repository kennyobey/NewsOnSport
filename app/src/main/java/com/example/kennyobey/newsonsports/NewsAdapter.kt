package com.example.kennyobey.newsonsports

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.recycler_items.*
import kotlinx.android.synthetic.main.recycler_items.view.*

class NewsAdapter (private  val context : Context, private  val newsfetch :NewsFetch ):
        RecyclerView.Adapter<NewsAdapter.NewsViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.NewsViewHolder {
        return NewsViewHolder(LayoutInflater.from(context).inflate(R.layout.sportnews,parent,false))
    }

    override fun getItemCount(): Int {
        return newsfetch.articles.size
    }

    override fun onBindViewHolder(holder:NewsViewHolder, position: Int) {
        val result  = newsfetch.articles[position]
        holder.itemView.news_title.text=result.title
        holder.itemView.news_description.text = result.description
        holder.itemView.news_source.text = result.source.toString()
        holder.itemView.news_time.text = result.publishedAt
        Glide.with(context).load(result.urlToImage).into(holder.itemView.news_image)
    }


    inner class NewsViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        init {
            itemView.setOnClickListener(this)
        }
        override fun onClick(v: View?){
            val result = newsfetch.articles[adapterPosition]
            val intent =Intent(context,NewsDetailActivity::class.java).apply {
                putExtra("Title", result.title)
                putExtra("Description", result.description)
            }
            context.startActivity(intent)
        }
    }
}

