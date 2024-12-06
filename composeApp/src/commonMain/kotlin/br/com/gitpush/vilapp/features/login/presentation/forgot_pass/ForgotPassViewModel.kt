package br.com.gitpush.vilapp.features.login.presentation.forgot_pass

import androidx.lifecycle.ViewModel
import br.com.gitpush.vilapp.features.login.domain.LoginRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

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
        TODO("Not yet implemented")
    }
}
