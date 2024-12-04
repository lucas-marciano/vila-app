package br.com.gitpush.vilapp.features.login.presentation

import br.com.gitpush.vilapp.core.presentation.UiText

data class LoginState(
    val success: Boolean = false,
    val inLoading: Boolean = false,
    val emailField: String = "",
    val passwordField: String = "",
    val rememberLogin: Boolean = false,
    val redirectRoute: String? = null,
    val errorMessage: UiText? = null,
) {
    fun checkFields() = emailField.isEmpty() || passwordField.isEmpty()
}
