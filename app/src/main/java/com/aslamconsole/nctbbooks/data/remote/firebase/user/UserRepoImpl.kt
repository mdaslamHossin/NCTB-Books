package com.aslamconsole.nctbbooks.data.remote.firebase.user

import android.net.Uri
import com.google.firebase.auth.FirebaseUser
import io.reactivex.Completable
import javax.inject.Inject


/**
 * Created by Aslam Hossin on 6/12/2021.
 * Monstar Lab, Dhaka, Bangladesh.
 * aslam.hossin@monstar-lab.com
 */
class UserRepoImpl @Inject constructor(val firebase: UserSource) : UserRepo {

    override fun login(email: String, password: String) = firebase.login(email, password)

    override fun register(email: String, password: String) = firebase.register(email, password)

    override fun forgotPassword(email: String) = firebase.forgotPassword(email)

    override fun currentUser(): FirebaseUser? = firebase.currentUser()

    override fun logout() = firebase.logout()

    override fun profileUpdate(photoUri: Uri, userName: String) =
        firebase.updateUserProfile(photoUri, userName)
}