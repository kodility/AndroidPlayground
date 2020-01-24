package com.monowar.androidprojecttemplate

sealed class Resource<T>(val status: Status, val data: T? = null, val cause: Throwable? = null) {

    enum class Status {
        SUCCESS, ERROR, LOADING
    }

    class Loading<T>(data: T? = null) : Resource<T>(Status.LOADING, data)
    class Success<T>(data: T) : Resource<T>(Status.SUCCESS, data)
    class Error<T>(cause: Throwable, data: T? = null) : Resource<T>(Status.ERROR, data, cause)
}
