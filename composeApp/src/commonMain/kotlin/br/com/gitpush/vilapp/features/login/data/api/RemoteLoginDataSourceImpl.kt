package br.com.gitpush.vilapp.features.login.data.api

import br.com.gitpush.vilapp.BASE_URL
import br.com.gitpush.vilapp.core.data.safeCall
import br.com.gitpush.vilapp.core.domain.Result
import br.com.gitpush.vilapp.core.domain.errors.DataError
import br.com.gitpush.vilapp.features.login.data.dto.LoginDataDto
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
            httpClient.post("$BASE_URL/login") {
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
            httpClient.post("$BASE_URL/check_user") {
                url {
                    parameters.append("token", token)
                }
            }
        }
    }

    override suspend fun recovery(email: String): Result<LoginDataDto, DataError.Remote> {
        return safeCall {
            httpClient.post("$BASE_URL/recovery") {
                url {
                    parameters.append("email", email)
                }
            }
        }
    }
}
