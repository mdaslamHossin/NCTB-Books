package com.aslamconsole.nctbbooks.data.remote.firebase.books

import android.util.Log
import com.aslamconsole.nctbbooks.data.dto.Book
import com.aslamconsole.nctbbooks.data.dto.Book.Companion.toBook
import com.aslamconsole.nctbbooks.data.dto.Category.Companion.toCategory
import com.aslamconsole.nctbbooks.data.remote.firebase.categories.CategorySource
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
class BookSource @Inject constructor(private val firestore: FirebaseFirestore) {

    companion object {

        const val BOOK_COLLECTION = "books"
    }

    suspend fun getBooks(id: Int): List<Book> {
        return try {
            firestore.collection(CategorySource.BOOK_CATEGORY_COLLECTION)
                .document("/$id").collection(BOOK_COLLECTION).get()
                .await().documents.mapNotNull {
                    it.toBook()
                }
        } catch (ex: Exception) {
            Log.e(CategorySource.BOOK_CATEGORY_COLLECTION, "$ex")
            emptyList()
        }
    }
}