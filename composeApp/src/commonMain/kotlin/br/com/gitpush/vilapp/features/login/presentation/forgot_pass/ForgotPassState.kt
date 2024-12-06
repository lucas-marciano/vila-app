package br.com.gitpush.vilapp.features.login.presentation.forgot_pass

import br.com.gitpush.vilapp.core.presentation.UiText

data class ForgotPassState(
    val success: Boolean = false,
    val inLoading: Boolean = false,
    val emailField: String = "",
    val errorMessage: UiText? = null,
)
