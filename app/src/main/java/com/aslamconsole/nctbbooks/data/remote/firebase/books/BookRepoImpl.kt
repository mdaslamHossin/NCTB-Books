package com.aslamconsole.nctbbooks.data.remote.firebase.books

import javax.inject.Inject


/**
 * Created by Aslam Hossin on 6/14/2021.
 * Monstar Lab, Dhaka, Bangladesh.
 * aslam.hossin@monstar-lab.com
 */
class BookRepoImpl @Inject constructor(private val bookSource: BookSource) : BookRepo {

    override suspend fun getBooks(id: Int) = bookSource.getBooks(id)
}