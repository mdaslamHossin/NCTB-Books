package com.aslamconsole.nctbbooks.ui.book

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.aslamconsole.nctbbooks.data.dto.Book
import com.aslamconsole.nctbbooks.data.utils.Resource
import com.aslamconsole.nctbbooks.databinding.ActivityBooksBinding
import com.aslamconsole.nctbbooks.ui.base.BaseActivity
import com.aslamconsole.nctbbooks.utils.observe
import dagger.hilt.android.AndroidEntryPoint


/**
 * Created by Aslam Hossin on 6/28/2021.
 * Monstar Lab, Dhaka, Bangladesh.
 * aslam.hossin@monstar-lab.com
 */
@AndroidEntryPoint
class BookActivity : BaseActivity() {

    companion object {

        private const val CAT_ID = "Cat_ID"
        fun getCallingIntent(
            context: Context,
            videoChatRoomId: Int
        ) = Intent(context, BookActivity::class.java)
            .putExtra(CAT_ID, videoChatRoomId)

    }

    private val viewModel: BookViewModel by viewModels()
    private lateinit var binding: ActivityBooksBinding
    private lateinit var bookListAdapter: BookListAdapter

    override fun initViewBinding() {
        binding = ActivityBooksBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        intent.extras?.run {
            viewModel.start(getInt(CAT_ID))
        }
        bookListAdapter = BookListAdapter()
        binding.recyclerView.adapter = bookListAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        viewModel.getBooks()
    }

    override fun observeViewModel() {
        super.observeViewModel()
        observe(viewModel.books, ::handleBooks)
    }


    private fun handleBooks(resource: Resource<List<Book>>?) {
        when (resource) {
            is Resource.Loading -> {
                binding.progressbar.visibility = View.VISIBLE
            }
            is Resource.Success -> {
                binding.progressbar.visibility = View.GONE
                bookListAdapter.submitList(resource.data)
            }
            is Resource.DataError -> {
                binding.progressbar.visibility = View.GONE
            }
        }
    }


}