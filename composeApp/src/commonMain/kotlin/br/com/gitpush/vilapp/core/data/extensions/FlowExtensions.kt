package br.com.gitpush.vilapp.core.data.extensions

import br.com.gitpush.vilapp.core.data.NetWorkResult
import br.com.gitpush.vilapp.core.domain.errors.NetworkErrorException
import kotlinx.coroutines.flow.flow

fun <T> toResultFlow(call: suspend () -> NetWorkResult<T?>) = flow {
    emit(NetWorkResult.Loading(true))
    call.invoke().let { response ->
        try {
            emit(NetWorkResult.Success(response.data))
        } catch (error: NetworkErrorException) {
            emit(NetWorkResult.Error(response.data, error.toString()))
        }
    }
}
