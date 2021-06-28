package com.aslamconsole.nctbbooks

import android.app.Application
import android.util.Log
import com.google.firebase.FirebaseApp
import dagger.hilt.android.HiltAndroidApp
import io.reactivex.plugins.RxJavaPlugins


/**
 * Created by Aslam Hossin on 6/12/2021.
 * Monstar Lab, Dhaka, Bangladesh.
 * aslam.hossin@monstar-lab.com
 */
@HiltAndroidApp
class BooksApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        RxJavaPlugins.setErrorHandler {
            Log.d("handle exception", "$it")
        }
    }
}