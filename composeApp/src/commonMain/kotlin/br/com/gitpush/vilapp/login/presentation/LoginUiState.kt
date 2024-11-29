package br.com.gitpush.vilapp.login.presentation

abstract class LoginUiState {
    object Idle : LoginUiState()
    object Loading : LoginUiState()
    class Error(throwable: Throwable) : LoginUiState()
    class Success(data: LoginData) : LoginUiState()
}