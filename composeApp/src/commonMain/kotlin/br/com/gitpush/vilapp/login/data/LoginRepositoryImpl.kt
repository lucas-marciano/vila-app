package br.com.gitpush.vilapp.login.data

import br.com.gitpush.vilapp.login.domain.LoginResponse
import br.com.gitpush.vilapp.core.data.NetWorkResult
import br.com.gitpush.vilapp.core.data.extensions.toResultFlow
import io.ktor.client.HttpClient
import kotlinx.coroutines.flow.Flow

class LoginRepositoryImpl(private val httpClient: HttpClient): LoginRepository {

    override fun logIn(email: String, password: String): Flow<NetWorkResult<LoginResponse?>> {
        return toResultFlow {
//            val response = httpClient.get("api url").body<LoginResponse>()
            val response = LoginResponse(
                id = "1",
                name = "Lucas Marciano",
                email = "lucas@email.com",
                type = "admin",
                token = "00000",
            )
            NetWorkResult.Success(response)
        }
    }
}
