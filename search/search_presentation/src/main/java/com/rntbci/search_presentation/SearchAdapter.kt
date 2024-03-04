package com.rntbci.search_presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rntbci.search_domain.model.Article
import com.rntbci.search_presentation.databinding.ViewHolderSearchArticlesBinding

class SearchAdapter(val listener: ClickListener) :
    RecyclerView.Adapter<SearchAdapter.MyViewHolder>() {

    private var list = listOf<Article>()

    fun setData(list: List<Article>) {
        this.list = list
        notifyItemInserted(this.list.lastIndex)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchAdapter.MyViewHolder {
        val binding =
            ViewHolderSearchArticlesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
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

    inner class MyViewHolder(val viewDataBinding: ViewHolderSearchArticlesBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root)

    fun ImageView.loadImage(url: String) {
        //var progressBar = ProgressBar(this.context)
        //progressBar.visibility = View.VISIBLE

        Glide.with(this).load(url).error(com.google.android.material.R.drawable.mtrl_ic_error)
            .into(this)


    }
}

interface ClickListener {
    fun onClick(item: List<Article>)
}