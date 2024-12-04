package br.com.gitpush.vilapp.features.login.presentation

sealed interface LoginActions {
    data class OnFilledEmail(val email: String) : LoginActions
    data class OnFilledPassword(val password: String) : LoginActions
    data class OnRememberLogin(val remember: Boolean) : LoginActions
    data object OnLoginAction : LoginActions
    data class OnRedirectAction(val route: String) : LoginActions
}
