package br.com.gitpush.vilapp.features.login.data.api

import br.com.gitpush.vilapp.core.domain.Result
import br.com.gitpush.vilapp.core.domain.errors.DataError
import br.com.gitpush.vilapp.features.login.data.dto.LoginDataDto

interface RemoteLoginDataSource {
    suspend fun logIn(email: String, password: String): Result<LoginDataDto, DataError.Remote>
    suspend fun checkLoggedUser(token: String): Result<LoginDataDto, DataError.Remote>
}
