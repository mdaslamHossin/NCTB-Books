package com.aslamconsole.nctbbooks.ui.category

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aslamconsole.nctbbooks.data.dto.Category
import com.aslamconsole.nctbbooks.data.remote.firebase.categories.CategoryRepo
import com.aslamconsole.nctbbooks.data.remote.firebase.user.UserRepo
import com.aslamconsole.nctbbooks.data.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * Created by Aslam Hossin on 6/12/2021.
 * Monstar Lab, Dhaka, Bangladesh.
 * aslam.hossin@monstar-lab.com
 */
@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val repository: UserRepo,
    private val categoryRepo: CategoryRepo
) : ViewModel() {

    val categories = MutableLiveData<Resource<List<Category>>>()
    val user by lazy {
        repository.currentUser()
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

}