package br.com.gitpush.vilapp.features.forgot_pass.domain

import br.com.gitpush.vilapp.core.domain.Result
import br.com.gitpush.vilapp.core.domain.errors.DataError
import br.com.gitpush.vilapp.features.login.domain.LoginData

interface ForgotPassRepository {
    suspend fun recoveryPassword(email: String): Result<LoginData, DataError.Remote>
}
