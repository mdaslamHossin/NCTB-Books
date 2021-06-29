package com.aslamconsole.nctbbooks.ui.book

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aslamconsole.nctbbooks.data.dto.Book
import com.aslamconsole.nctbbooks.data.remote.firebase.books.BookRepo
import com.aslamconsole.nctbbooks.data.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * Created by Aslam Hossin on 6/28/2021.
 * Monstar Lab, Dhaka, Bangladesh.
 * aslam.hossin@monstar-lab.com
 */
@HiltViewModel
class BookViewModel @Inject constructor(
    private val bookRepo: BookRepo
) : ViewModel() {

    private val _id = MutableLiveData<Int>()

    fun start(id: Int) {
        _id.value = id
    }

    val books = MutableLiveData<Resource<List<Book>>>()


    fun getBooks() {
        viewModelScope.launch {
            books.value = Resource.Loading()
            try {
                _id.value?.let {
                    books.value = Resource.Success(bookRepo.getBooks(it))
                }

            } catch (ex: Exception) {
                books.value = Resource.DataError(ex)
            }
        }
    }
}