package com.aslamconsole.nctbbooks.data.remote.firebase.categories

import com.aslamconsole.nctbbooks.data.dto.Category


/**
 * Created by Aslam Hossin on 6/14/2021.
 * Monstar Lab, Dhaka, Bangladesh.
 * aslam.hossin@monstar-lab.com
 */
interface CategoryRepo {
    suspend fun getBookCategories(): List<Category>
}