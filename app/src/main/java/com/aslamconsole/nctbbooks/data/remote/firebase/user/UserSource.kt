package com.aslamconsole.nctbbooks.data.remote.firebase.user

import android.net.Uri
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import io.reactivex.Completable
import javax.inject.Inject
import javax.inject.Singleton


/**
 * Created by Aslam Hossin on 6/12/2021.
 * Monstar Lab, Dhaka, Bangladesh.
 * aslam.hossin@monstar-lab.com
 */
@Singleton
class UserSource @Inject constructor(private val firebaseAuth: FirebaseAuth) {

    fun login(email: String, password: String) = Completable.create { emitter ->
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
            if (!emitter.isDisposed) {
                if (it.isSuccessful)
                    emitter.onComplete()
                else
                    emitter.onError(it.exception ?: Throwable())
            }
        }
    }

    fun register(email: String, password: String) = Completable.create { emitter ->
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
            if (!emitter.isDisposed) {
                if (it.isSuccessful)
                    emitter.onComplete()
                else
                    emitter.onError(it.exception ?: Throwable())
            }
        }
    }

    fun forgotPassword(email: String) = Completable.create { emitter ->
        firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener {
            if (!emitter.isDisposed) {
                if (it.isSuccessful)
                    emitter.onComplete()
                else
                    emitter.onError(it.exception ?: Throwable())
            }
        }
    }

    fun logout() = firebaseAuth.signOut()

    fun currentUser() = firebaseAuth.currentUser

    fun updateUserProfile(photoUri: Uri, userName: String) = Completable.create { emitter ->
        firebaseAuth.currentUser?.let {
            val profileProperties = UserProfileChangeRequest.Builder()
                .setDisplayName(userName)
                .setPhotoUri(photoUri)
                .build()

            it.updateProfile(profileProperties).addOnCompleteListener { task ->
                if (!emitter.isDisposed) {
                    if (task.isSuccessful)
                        emitter.onComplete()
                    else
                        emitter.onError(task.exception ?: Throwable())
                }
            }

        }
    }
}