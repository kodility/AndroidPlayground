package com.androidplayground.libapi

sealed class NetworkState<T> {
    data class Loading<T>(val loadingStatus: LoadingStatus = LoadingStatus.DEFAULT) : NetworkState<T>() {
        enum class LoadingStatus {
            DEFAULT, INITIAL, REFRESH
        }
    }

    data class Success<T>(val data: T) : NetworkState<T>()
    data class Error<T>(val error: Throwable) : NetworkState<T>()
}

data class Resource<T> constructor(val status: Status, val data: T? = null, val cause: Throwable? = null) {

    enum class Status {
        SUCCESS, ERROR, LOADING
    }

    companion object {
        fun <T> success(data: T? = null): Resource<T> = Resource(Status.SUCCESS, data, null)

        fun <T> error(cause: Throwable?, data: T? = null): Resource<T> = Resource(Status.ERROR, data, cause)

        fun <T> loading(data: T? = null): Resource<T> = Resource(Status.LOADING, data, null)
    }

    fun loading(): Resource<T> = copy(status = Status.LOADING)
    fun success(data: T): Resource<T> = copy(status = Status.SUCCESS, data = data, cause = null)
    fun error(cause: Throwable): Resource<T> = copy(status = Status.ERROR, cause = cause)
}
