package br.com.gitpush.vilapp.login.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.gitpush.vilapp.core.presentation.UiText
import br.com.gitpush.vilapp.login.data.LoginRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import vilapp.composeapp.generated.resources.Res
import vilapp.composeapp.generated.resources.vila_app_field_empty_error

class LoginViewModel(
    private val repository: LoginRepository
) : ViewModel() {

    private val _state = MutableStateFlow(LoginState())
    val state = _state.asStateFlow()

    fun onAction(action: LoginActions) {
        when (action) {
            is LoginActions.OnLoginAction -> {
                _state.update { it.copy(inLoading = true) }
                login()
            }

            is LoginActions.OnFilledEmail -> {
                if (!_state.value.inLoading) {
                    _state.update {
                        it.copy(emailField = action.email)
                    }
                }
            }

            is LoginActions.OnFilledPassword -> {
                if (!_state.value.inLoading) {
                    _state.update {
                        it.copy(passwordField = action.password)
                    }
                }
            }

            is LoginActions.OnRememberLogin -> {
                if (!_state.value.inLoading) {
                    _state.update {
                        it.copy(rememberLogin = action.remember)
                    }
                }
            }

            is LoginActions.OnRedirectAction -> {
                if (!_state.value.inLoading) {
                    _state.update { it.copy(redirectRoute = action.route) }
                }
            }
        }
    }


    private fun login() {
        viewModelScope.launch {
            delay(3000)
            if (_state.value.checkFields()) {
                _state.update {
                    it.copy(
                        inLoading = false,
                        errorMessage = UiText.StringResourceId(Res.string.vila_app_field_empty_error)
                    )
                }
            } else {
                _state.update {
                    it.copy(
                        inLoading = false,
                        success = true
                    )
                }
            }
//                val response = repository.logIn(filedEmail.value, filedPassword.value)
//                response.collect {
//
//                }
//            } else {
//                state.value = LoginUiState.Error(ErrorFieldException("Preencha todos os campos"))
//            }
        }
    }
}
