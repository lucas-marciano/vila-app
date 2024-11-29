package br.com.gitpush.vilapp.login.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.gitpush.vilapp.login.data.LoginRepository
import br.com.gitpush.vilapp.core.domain.errors.ErrorFieldException
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    private val repository: LoginRepository
) : ViewModel() {
    val filedEmail = MutableStateFlow("")
    val filedPassword = MutableStateFlow("")
    var state = MutableStateFlow<LoginUiState>(LoginUiState.Idle)
        private set

    fun login() {
        viewModelScope.launch {
            state.value = LoginUiState.Loading
            delay(3000)
            if (filedEmail.value.isEmpty() || filedPassword.value.isEmpty()) {
                val response = repository.logIn(filedEmail.value, filedPassword.value)
                response.collect {

                }
            } else {
                state.value = LoginUiState.Error(ErrorFieldException("Preencha todos os campos"))
            }
        }
    }
}
