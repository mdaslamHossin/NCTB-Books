package com.aslamconsole.nctbbooks.data.utils


/**
 * Created by Aslam Hossin on 6/13/2021.
 * Monstar Lab, Dhaka, Bangladesh.
 * aslam.hossin@monstar-lab.com
 */
sealed class Resource<T>(
    val data: T? = null,
    val throwable: Throwable? = null
) {

    class Success<T>(data: T) : Resource<T>(data)
    class Loading<T>(data: T? = null) : Resource<T>(data)
    class DataError<T>(throwable: Throwable) : Resource<T>(null, throwable)

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is DataError -> "Error[exception=$throwable]"
            is Loading<T> -> "Loading"
        }
    }
}
