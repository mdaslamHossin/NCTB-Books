package com.aslamconsole.nctbbooks.data.remote.firebase.books

import com.aslamconsole.nctbbooks.data.dto.Book
import com.aslamconsole.nctbbooks.data.dto.Category


/**
 * Created by Aslam Hossin on 6/14/2021.
 * Monstar Lab, Dhaka, Bangladesh.
 * aslam.hossin@monstar-lab.com
 */
interface BookRepo {
    suspend fun getBooks(id:Int): List<Book>
}