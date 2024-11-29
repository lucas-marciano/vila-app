package br.com.gitpush.vilapp.login.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import br.com.gitpush.vilapp.ui.theme.VilaTheme
import br.com.gitpush.vilapp.ui.components.buttons.MainButton
import br.com.gitpush.vilapp.ui.components.textfields.MainTextFieldEmail
import br.com.gitpush.vilapp.ui.components.textfields.MainTextFieldPassword
import br.com.gitpush.vilapp.ui.components.textfields.TextFieldInfoData
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.getKoin

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    val viewModel: LoginViewModel = getKoin().get()
    val state by viewModel.state.collectAsState()

    LoginContent(
        modifier = modifier,
        state = { state },
        onEmailChange = {
            viewModel.filedEmail.value = it
        }, onPasswordChange = {
            viewModel.filedPassword.value = it
        },
        onActionLogin = {
            viewModel.login()
        }
    )
}

@Composable
fun LoginContent(
    modifier: Modifier = Modifier,
    onEmailChange: (String) -> Unit = {},
    onPasswordChange: (String) -> Unit = {},
    onActionLogin: () -> Unit = {},
    state: () -> LoginUiState = { LoginUiState.Idle },
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val enabledButton by remember { mutableStateOf(checkLogin(email, password)) }
    val localState by remember { mutableStateOf(state()) }

    Column(
        modifier = modifier.fillMaxSize()
            .background(VilaTheme.colors.background)
            .padding(VilaTheme.spaces.large),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            style = VilaTheme.typography.h1,
            text = "Login"
        )

        Spacer(modifier = Modifier.padding(bottom = VilaTheme.spaces.medium))

        MainTextFieldEmail(
            data = TextFieldInfoData(
                value = email,
                placeholder = "E-mail",
                enabled = !localState.isLoading()
            )
        ) {
            email = it
            onEmailChange(email)
        }

        Spacer(modifier = Modifier.padding(bottom = VilaTheme.spaces.medium))

        MainTextFieldPassword(
            data = TextFieldInfoData(
                value = password,
                placeholder = "Senha",
                enabled = !localState.isLoading()
            )
        ) {
            password = it
            onPasswordChange(password)
        }

        Spacer(modifier = Modifier.padding(bottom = VilaTheme.spaces.medium))

        MainButton(
            text = "Acessar",
            onClick = onActionLogin,
            enabled = enabledButton,
            loading = localState.isLoading()
        )
    }
}

private fun LoginUiState.isLoading() = this is LoginUiState.Loading

private fun checkLogin(email: String, password: String) =
    email.trim().isNotEmpty() && password.trim().isNotEmpty()

@Composable
@Preview
private fun LoginScreenPreview() {
    LoginContent()
}
