package com.aslamconsole.nctbbooks.ui.home

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.aslamconsole.nctbbooks.data.dto.Book
import com.aslamconsole.nctbbooks.data.dto.Category
import com.aslamconsole.nctbbooks.data.utils.Resource
import com.aslamconsole.nctbbooks.databinding.ActivityHomeBinding
import com.aslamconsole.nctbbooks.ui.base.BaseActivity
import com.aslamconsole.nctbbooks.utils.observe
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BaseActivity() {

    private val viewModel: HomeViewModel by viewModels()
    private lateinit var binding: ActivityHomeBinding

    override fun initViewBinding() {
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewmodel = viewModel
        viewModel.getBookCategories()
        viewModel.getBooks(0)
    }

    override fun observeViewModel() {
        super.observeViewModel()
        observe(viewModel.categories, ::handleBookCategories)
        observe(viewModel.books, ::handleBooks)
    }

    private fun handleBookCategories(resource: Resource<List<Category>>?) {
        when (resource) {
            is Resource.Loading -> {
                Log.d("Categories", "Loading ")
            }
            is Resource.Success -> {
                Log.d("Categories", "${resource.data}")
            }
            is Resource.DataError -> {
                Log.d("Categories", "${resource.data}")
            }
        }
    }

    private fun handleBooks(resource: Resource<List<Book>>?) {
        when (resource) {
            is Resource.Loading -> {
                Log.d("Books", "Loading ")
            }
            is Resource.Success -> {
                Log.d("Books", "${resource.data}")
            }
            is Resource.DataError -> {
                Log.d("Books", "${resource.data}")
            }
        }
    }


}
