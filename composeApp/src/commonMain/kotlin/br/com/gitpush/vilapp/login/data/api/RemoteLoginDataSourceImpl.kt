package br.com.gitpush.vilapp.login.data.api

import br.com.gitpush.vilapp.core.data.safeCall
import br.com.gitpush.vilapp.core.domain.Result
import br.com.gitpush.vilapp.core.domain.errors.DataError
import br.com.gitpush.vilapp.login.data.dto.LoginDataDto
import io.ktor.client.HttpClient
import io.ktor.client.request.post

class RemoteLoginDataSourceImpl(
    private val httpClient: HttpClient
) : RemoteLoginDataSource {
    override suspend fun logIn(
        email: String,
        password: String
    ): Result<LoginDataDto, DataError.Remote> {
        return safeCall {
            httpClient.post("") {
                url {
                    parameters.append("email", email)
                    parameters.append("password", password)
                }
            }
        }
    }

    override suspend fun checkLoggedUser(
        token: String
    ): Result<LoginDataDto, DataError.Remote> {
        return safeCall {
            httpClient.post("") {
                url {
                    parameters.append("token", token)
                }
            }
        }
    }
}
