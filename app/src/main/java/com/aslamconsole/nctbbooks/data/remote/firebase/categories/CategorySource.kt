package com.aslamconsole.nctbbooks.data.remote.firebase.categories

import android.util.Log
import com.aslamconsole.nctbbooks.data.dto.Category
import com.aslamconsole.nctbbooks.data.dto.Category.Companion.toCategory
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton


/**
 * Created by Aslam Hossin on 6/14/2021.
 * Monstar Lab, Dhaka, Bangladesh.
 * aslam.hossin@monstar-lab.com
 */
@Singleton
class CategorySource @Inject constructor(private val firestore: FirebaseFirestore) {

    companion object {

        const val BOOK_CATEGORY_COLLECTION = "categories"
    }

    suspend fun getBookCategories(): List<Category> {
        return try {
            firestore.collection(BOOK_CATEGORY_COLLECTION)
                .get().await().documents.mapNotNull { it.toCategory() }
        } catch (ex: Exception) {
            Log.e(BOOK_CATEGORY_COLLECTION, "$ex")
            emptyList()
        }
    }

}