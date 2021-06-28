package com.aslamconsole.nctbbooks.data.remote.firebase.categories

import javax.inject.Inject


/**
 * Created by Aslam Hossin on 6/14/2021.
 * Monstar Lab, Dhaka, Bangladesh.
 * aslam.hossin@monstar-lab.com
 */
class CategoryRepoImpl @Inject constructor(private val categorySource: CategorySource) :
    CategoryRepo {

    override suspend fun getBookCategories() = categorySource.getBookCategories()
}