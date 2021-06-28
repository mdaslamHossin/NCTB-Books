package com.aslamconsole.nctbbooks.ui.home

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aslamconsole.nctbbooks.data.dto.Book
import com.aslamconsole.nctbbooks.data.dto.Category
import com.aslamconsole.nctbbooks.data.remote.firebase.books.BookRepo
import com.aslamconsole.nctbbooks.data.remote.firebase.categories.CategoryRepo
import com.aslamconsole.nctbbooks.data.remote.firebase.user.UserRepo
import com.aslamconsole.nctbbooks.data.utils.Resource
import com.aslamconsole.nctbbooks.utils.startLoginActivity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * Created by Aslam Hossin on 6/12/2021.
 * Monstar Lab, Dhaka, Bangladesh.
 * aslam.hossin@monstar-lab.com
 */
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: UserRepo,
    private val categoryRepo: CategoryRepo,
    private val bookRepo: BookRepo
) : ViewModel() {

    val categories = MutableLiveData<Resource<List<Category>>>()
    val books = MutableLiveData<Resource<List<Book>>>()
    val user by lazy {
        repository.currentUser()
    }

    fun logout(view: View) {
        repository.logout()
        view.context.startLoginActivity()
    }

    fun getBookCategories() {
        viewModelScope.launch {
            categories.value = Resource.Loading()
            try {
                categories.value = Resource.Success(categoryRepo.getBookCategories())
            } catch (ex: Exception) {
                categories.value = Resource.DataError(ex)
            }
        }
    }

    fun getBooks(id: Int) {
        viewModelScope.launch {
            books.value = Resource.Loading()
            try {
                books.value = Resource.Success(bookRepo.getBooks(id))
            } catch (ex: Exception) {
                categories.value = Resource.DataError(ex)
            }
        }
    }
}