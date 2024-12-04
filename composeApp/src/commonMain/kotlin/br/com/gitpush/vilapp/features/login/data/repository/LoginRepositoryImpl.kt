package br.com.gitpush.vilapp.features.login.data.repository

import br.com.gitpush.vilapp.core.domain.Result
import br.com.gitpush.vilapp.core.domain.errors.DataError
import br.com.gitpush.vilapp.core.domain.map
import br.com.gitpush.vilapp.features.login.domain.LoginData
import br.com.gitpush.vilapp.features.login.data.api.RemoteLoginDataSource
import br.com.gitpush.vilapp.features.login.data.mappers.toLoginData
import br.com.gitpush.vilapp.features.login.domain.LoginRepository

class LoginRepositoryImpl(
    private val dataSource: RemoteLoginDataSource
) : LoginRepository {
    override suspend fun logIn(
        email: String,
        password: String
    ): Result<LoginData, DataError.Remote> {
        return dataSource
            .logIn(email, password)
            .map {
                it.toLoginData()
            }
    }

    override suspend fun checkLoggedUser(token: String): Result<LoginData, DataError.Remote> {
        return dataSource
            .checkLoggedUser(token)
            .map {
                it.toLoginData()
            }
    }

}
