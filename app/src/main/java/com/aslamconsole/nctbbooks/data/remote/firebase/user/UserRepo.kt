package com.aslamconsole.nctbbooks.data.remote.firebase.user

import android.net.Uri
import com.google.firebase.auth.FirebaseUser
import io.reactivex.Completable


/**
 * Created by Aslam Hossin on 6/13/2021.
 * Monstar Lab, Dhaka, Bangladesh.
 * aslam.hossin@monstar-lab.com
 */
interface UserRepo {

    fun login(email: String, password: String): Completable

    fun register(email: String, password: String): Completable

    fun forgotPassword(email: String): Completable

    fun currentUser(): FirebaseUser?

    fun logout()

    fun profileUpdate(photoUri: Uri, userName: String): Completable
}