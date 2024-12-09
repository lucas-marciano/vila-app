package br.com.gitpush.vilapp.features.login.presentation.forgot_pass

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

class ForgotPassViewModel(
    private val repository: LoginRepository
) : ViewModel() {

    private val _state = MutableStateFlow(ForgotPassState())
    val state = _state.asStateFlow()

    fun onAction(action: ForgotPassActions) {
        when (action) {
            is ForgotPassActions.OnFilledEmail -> {
                _state.update {
                    it.copy(emailField = action.email)
                }
            }

            is ForgotPassActions.OnRecoveryAction -> {
                _state.update {
                    it.copy(inLoading = true)
                }
                forgotPassword(state.value.emailField)
            }
        }
    }

    private fun forgotPassword(emailField: String) {
        viewModelScope.launch {
            delay(3000)
            if (emailField.isNotEmpty()) {
                _state.update {
                    it.copy(
                        success = true,
                        inLoading = false
                    )
                }

//                repository.recoveryPassword(emailField)
//                    .onSuccess {
//                        _state.update {
//                            it.copy(
//                                success = true,
//                                inLoading = false
//                            )
//                        }
//                    }
//                    .onError { error ->
//                        _state.update {
//                            it.copy(
//                                success = false,
//                                inLoading = false,
//                                errorMessage = error.toUiText()
//                            )
//                        }
//                    }
            } else {
                _state.update {
                    it.copy(
                        success = false,
                        inLoading = false,
                        errorMessage = UiText.StringResourceId(Res.string.vila_app_field_empty_error)
                    )
                }
            }
        }

    }
}
