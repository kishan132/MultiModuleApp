package com.rntbci.news_presentation

import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rntbci.news_domain.model.Article
import com.rntbci.news_presentation.databinding.ViewHolderArticlesBinding

class NewsAdapter(val listener : ClickListener) : RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {

    private var list = listOf<Article>()

    fun setData(list: List<Article>) {
        this.list = list
        notifyItemInserted(this.list.lastIndex)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.MyViewHolder {
        val binding =
            ViewHolderArticlesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.viewDataBinding.apply {
            val item = list[position]

            ivArticle.loadImage(item.urlToImage)
            tvHeadlines.text = item.title
            tvContent.text = item.content
        }
    }

    override fun getItemCount(): Int {
        return this.list.size
    }

    inner class MyViewHolder(val viewDataBinding: ViewHolderArticlesBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root)

    fun ImageView.loadImage(url: String) {
        //var progressBar = ProgressBar(this.context)
        //progressBar.visibility = View.VISIBLE

        Glide.with(this).load(url).error(com.google.android.material.R.drawable.mtrl_ic_error)
            .into(this)


    }
}

interface ClickListener{
    fun onClick(item: List<Article>)
}