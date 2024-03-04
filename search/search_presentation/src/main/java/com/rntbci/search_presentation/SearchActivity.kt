package com.rntbci.search_presentation

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.lifecycleScope
import com.google.android.material.datepicker.MaterialDatePicker
import com.rntbci.common_utils.Navigator
import com.rntbci.search_domain.model.Article
import com.rntbci.search_presentation.databinding.ActivitySearchBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat

@AndroidEntryPoint
class SearchActivity : AppCompatActivity(), ClickListener {

    companion object {
        fun launchActivity(activity: Activity) {
            val intent = Intent(activity, SearchActivity::class.java)
            activity.startActivity(intent)
        }
    }

    private lateinit var binding: ActivitySearchBinding

    private val searchViewModel: SearchViewModel by viewModels()

    private val searchAdapter = SearchAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()

        setObserver()
    }

    private fun setObserver() {
        lifecycleScope.launch {
            searchViewModel.searchArticle.collectLatest {

                if (it.isLoading) {
                    binding.progressBar.visibility = View.VISIBLE
                }

                if (it.isError.isNotBlank()) {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(this@SearchActivity, it.isError, Toast.LENGTH_SHORT).show()
                }

                it.data?.let {
                    binding.progressBar.visibility = View.GONE
                    searchAdapter.setData(it)
                }
            }
        }
    }

    private fun initView() {

        binding.rvSearch.adapter = searchAdapter

        //https://newsapi.org/v2/everything?q=apple&from=2024-03-10&to=2024-03-10&sortBy=popularity&apiKey=API_KEY
        binding.searchTitle.doAfterTextChanged {
            val map = mutableMapOf<String, String>()
            map[Constants.KEY] = com.rntbci.common_utils.Constants.API_KEY
            map[Constants.QUERY] = it.toString()

            searchViewModel.getSearchArticles(map)
        }


        binding.ivRange.setOnClickListener {

            val datePicker = MaterialDatePicker.Builder.dateRangePicker().build()
            datePicker.show(this.supportFragmentManager, "rangePicker")

            datePicker.addOnPositiveButtonClickListener {
                val start = changeDateFormat(it.first)
                val end = changeDateFormat(it.second)

                val map = mutableMapOf<String, String>()
                map[Constants.KEY] = com.rntbci.common_utils.Constants.API_KEY
                map[Constants.QUERY] = binding.searchTitle.text.toString()
                map[Constants.START_DATE] = start
                map[Constants.END_DATE] = end

                searchViewModel.getSearchArticles(map)
            }
        }

    }

    private fun changeDateFormat(long: Long?): String {
        return try {
            val simpleDateFormat = SimpleDateFormat("yyyy-mm-dd")
            simpleDateFormat.format(long)
        } catch (e: Exception) {
            ""
        }
    }

    override fun onClick(item: List<Article>) {

    }
}

object GoToSearchActivity : Navigator {
    override fun navigate(activity: Activity) {
        SearchActivity.launchActivity(activity)
    }

}