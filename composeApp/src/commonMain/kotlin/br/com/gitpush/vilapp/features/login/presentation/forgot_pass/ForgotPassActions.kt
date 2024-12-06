package br.com.gitpush.vilapp.features.login.presentation.forgot_pass

sealed interface ForgotPassActions {
    data class OnFilledEmail(val email: String) : ForgotPassActions
    data object OnRecoveryAction : ForgotPassActions
}
