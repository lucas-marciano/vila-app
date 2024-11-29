package br.com.gitpush.vilapp.core.data

sealed class NetWorkResult<out T>(val status: ApiStatus, val data: T?, val message: String?) {

    data class Success<out T>(val response: T?) :
        NetWorkResult<T>(status = ApiStatus.SUCCESS, data = response, message = null)

    data class Error<out T>(val response: T?, val exception: String) :
        NetWorkResult<T>(status = ApiStatus.ERROR, data = response, message = exception)

    data class Loading<out T>(val isLoading: Boolean) :
        NetWorkResult<T>(status = ApiStatus.LOADING, data = null, message = null)
}

enum class ApiStatus {
    SUCCESS,
    ERROR,
    LOADING,
}