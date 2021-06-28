package com.aslamconsole.nctbbooks.ui.auth


/**
 * Created by Aslam Hossin on 6/12/2021.
 * Monstar Lab, Dhaka, Bangladesh.
 * aslam.hossin@monstar-lab.com
 */

interface AuthListener {
    fun onStarted()
    fun onSuccess()
    fun onFailure(message: String)
}