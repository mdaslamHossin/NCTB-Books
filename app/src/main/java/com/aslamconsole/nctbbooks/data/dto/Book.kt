package com.aslamconsole.nctbbooks.data.dto

import android.media.Image
import android.util.Log
import com.aslamconsole.nctbbooks.data.remote.firebase.categories.CategorySource
import com.google.firebase.firestore.DocumentSnapshot


/**
 * Created by Aslam Hossin on 6/14/2021.
 * Monstar Lab, Dhaka, Bangladesh.
 * aslam.hossin@monstar-lab.com
 */
data class Book(
    val name: String,
    val image: String,
    val urlBn: String,
    val urlEn: String
) {

    companion object {

        private const val NAME = "name"
        private const val IMAGE = "image"
        private const val BN_URL = "urlBn"
        private const val EN_URL = "urlEn"
        fun DocumentSnapshot.toBook(): Book? {
            return try {
                val name = getString(NAME) ?: ""
                val image = getString(IMAGE) ?: ""
                val urlBn = getString(BN_URL) ?: ""
                val urlEn = getString(EN_URL) ?: ""
                Book(name, image, urlBn, urlEn)
            } catch (e: Exception) {
                Log.e(CategorySource.BOOK_CATEGORY_COLLECTION, "$e")
                null
            }
        }
    }
}