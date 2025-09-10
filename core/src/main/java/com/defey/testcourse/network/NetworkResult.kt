package com.defey.testcourse.network

sealed class NetworkResult<out T> {
    data class Success<out T>(val data: T) : NetworkResult<T>()
    data class Error(val message: String?, val code: Int? = null) : NetworkResult<Nothing>()
}

suspend fun <T : Any> NetworkResult<T>.onSuccess(
    executable: suspend (T) -> Unit,
): NetworkResult<T> = apply {
    if (this is NetworkResult.Success<T>) {
        executable(data)
    }
}

suspend fun <T : Any> NetworkResult<T>.onError(
    executable: suspend () -> Unit,
): NetworkResult<T> = apply {
    if (this !is NetworkResult.Success) {
        executable()
    }
}

suspend fun <T : Any> NetworkResult<T>.finally(
    executable: suspend (NetworkResult<T>) -> Unit,
): NetworkResult<T> = apply {
    executable(this)
}

