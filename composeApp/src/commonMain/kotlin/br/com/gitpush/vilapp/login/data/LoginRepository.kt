package br.com.gitpush.vilapp.login.data

import br.com.gitpush.vilapp.login.domain.LoginResponse
import br.com.gitpush.vilapp.core.data.NetWorkResult
import kotlinx.coroutines.flow.Flow

interface LoginRepository {
    fun logIn(email: String, password: String): Flow<NetWorkResult<LoginResponse?>>
}