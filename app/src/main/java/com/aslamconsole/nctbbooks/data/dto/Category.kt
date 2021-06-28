package com.aslamconsole.nctbbooks.data.dto

import android.util.Log
import com.aslamconsole.nctbbooks.data.remote.firebase.categories.CategorySource.Companion.BOOK_CATEGORY_COLLECTION
import com.google.firebase.firestore.DocumentSnapshot


/**
 * Created by Aslam Hossin on 6/14/2021.
 * Monstar Lab, Dhaka, Bangladesh.
 * aslam.hossin@monstar-lab.com
 */

data class Category(val id: Int, val name: String) {

    companion object {

        private const val CAT_ID = "id"
        private const val CAT_NAME = "name"
        fun DocumentSnapshot.toCategory(): Category? {
            return try {
                val id = getLong(CAT_ID)?.toInt() ?: -1
                val name = getString(CAT_NAME) ?: ""
                Category(id, name)
            } catch (e: Exception) {
                Log.e(BOOK_CATEGORY_COLLECTION, "$e")
                null
            }
        }
    }
}