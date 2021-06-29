package com.aslamconsole.nctbbooks.utils

import android.content.Context
import android.content.Intent
import com.aslamconsole.nctbbooks.ui.auth.LoginActivity
import com.aslamconsole.nctbbooks.ui.category.CategoryActivity


/**
 * Created by Aslam Hossin on 6/12/2021.
 * Monstar Lab, Dhaka, Bangladesh.
 * aslam.hossin@monstar-lab.com
 */

fun Context.startHomeActivity() =
    Intent(this, CategoryActivity::class.java).also {
        it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(it)
    }

fun Context.startLoginActivity() =
    Intent(this, LoginActivity::class.java).also {
        it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(it)
    }
