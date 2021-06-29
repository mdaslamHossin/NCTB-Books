package com.aslamconsole.nctbbooks.ui.category

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.aslamconsole.nctbbooks.data.dto.Category
import com.aslamconsole.nctbbooks.data.utils.Resource
import com.aslamconsole.nctbbooks.databinding.ActivityCategoryBinding
import com.aslamconsole.nctbbooks.ui.base.BaseActivity
import com.aslamconsole.nctbbooks.utils.observe
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoryActivity : BaseActivity() {

    private val viewModel: CategoryViewModel by viewModels()
    private lateinit var binding: ActivityCategoryBinding
    private lateinit var categoryListAdapter: CategoryListAdapter

    override fun initViewBinding() {
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        categoryListAdapter = CategoryListAdapter()
        binding.recyclerView.adapter = categoryListAdapter
        binding.recyclerView.layoutManager = GridLayoutManager(this, 2)
        viewModel.getBookCategories()
    }

    override fun observeViewModel() {
        super.observeViewModel()
        observe(viewModel.categories, ::handleBookCategories)
    }

    private fun handleBookCategories(resource: Resource<List<Category>>?) {
        when (resource) {
            is Resource.Loading -> {
                binding.progressbar.visibility = View.VISIBLE
            }
            is Resource.Success -> {
                binding.progressbar.visibility = View.GONE
                categoryListAdapter.submitList(resource.data)
            }
            is Resource.DataError -> {
                binding.progressbar.visibility = View.GONE
            }
        }
    }


}
