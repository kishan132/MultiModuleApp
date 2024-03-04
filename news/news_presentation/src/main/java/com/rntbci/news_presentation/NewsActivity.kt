package com.rntbci.news_presentation

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.rntbci.common_utils.Activities
import com.rntbci.common_utils.Navigator
import com.rntbci.news_domain.model.Article
import com.rntbci.news_presentation.databinding.ActivityNewsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class NewsActivity : AppCompatActivity(), ClickListener {

    companion object {
        fun launchActivity(activity: Activity) {
            val intent = Intent(activity, NewsActivity::class.java)
            activity.startActivity(intent)
        }
    }

    private lateinit var binding: ActivityNewsBinding

    private lateinit var newsAdapter: NewsAdapter

    @Inject
    lateinit var provider: Navigator.Provider


    private val newsViewModel: NewsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        setObservers()
    }

    private fun initView() {
        newsAdapter = NewsAdapter(this)
        binding.rvArticles.adapter = newsAdapter

        binding.ivGoToSearch.setOnClickListener {
            provider.getActivities(Activities.SearchActivity).navigate(this)
        }
    }

    private fun setObservers() {
        lifecycleScope.launch {
            newsViewModel.newsActivity.collectLatest {
                if (it.isLoading) {
                    binding.progressBar.visibility = View.VISIBLE
                }
                if (it.error.isNotBlank()) {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(this@NewsActivity, it.error, Toast.LENGTH_SHORT).show()
                }

                it.data?.let {
                    binding.progressBar.visibility = View.GONE
                    newsAdapter.setData(it)
                }
            }
        }
    }

    override fun onClick(item: List<Article>) {

    }
}

object GoToNewsActivity : Navigator {
    override fun navigate(activity: Activity) {
        NewsActivity.launchActivity(activity)
    }

}