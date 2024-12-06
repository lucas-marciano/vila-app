package br.com.gitpush.vilapp.features.login.domain

import br.com.gitpush.vilapp.core.domain.Result
import br.com.gitpush.vilapp.core.domain.errors.DataError

interface LoginRepository {
    suspend fun logIn(email: String, password: String): Result<LoginData, DataError.Remote>
    suspend fun checkLoggedUser(token: String): Result<LoginData, DataError.Remote>
    suspend fun recoveryPassword(email: String): Result<LoginData, DataError.Remote>
}