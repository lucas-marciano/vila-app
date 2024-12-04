package br.com.gitpush.vilapp.features.login.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.gitpush.vilapp.core.presentation.UiText
import br.com.gitpush.vilapp.features.login.domain.LoginRepository
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
                login(state.value.emailField, state.value.passwordField)
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

    private fun login(email: String, password: String) = viewModelScope.launch {
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
                    errorMessage = null,
                    success = true
                )
            }
//            repository
//                .logIn(email = email, password = password)
//                .onSuccess { result ->
//                    _state.update {
//                        it.copy(
//                            inLoading = false,
//                            errorMessage = null,
//                            success = result.email.isNotEmpty()
//                        )
//                    }
//                }
//                .onError { error ->
//                    _state.update {
//                        it.copy(
//                            inLoading = false,
//                            errorMessage = error.toUiText()
//                        )
//                    }
//                }
        }
    }
}
