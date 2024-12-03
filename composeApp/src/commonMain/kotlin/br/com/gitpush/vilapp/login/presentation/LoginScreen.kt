package br.com.gitpush.vilapp.login.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import br.com.gitpush.vilapp.core.domain.Routes
import br.com.gitpush.vilapp.ui.components.buttons.LoadingButton
import br.com.gitpush.vilapp.ui.components.textfields.MainTextFieldEmail
import br.com.gitpush.vilapp.ui.components.textfields.MainTextFieldPassword
import br.com.gitpush.vilapp.ui.theme.VilaTheme
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import vilapp.composeapp.generated.resources.Res
import vilapp.composeapp.generated.resources.vila_app_forgot_pass_button
import vilapp.composeapp.generated.resources.vila_app_login_button
import vilapp.composeapp.generated.resources.vila_app_login_title

@Composable
fun LoginScreenRoute(
    viewModel: LoginViewModel = koinViewModel(),
    onRedirectAction: (String) -> Unit = {}
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    if (state.success) {
        // salvar informacoes antes de ir para home
        // usar algo pro token e pros dados dos cliente logado
        onRedirectAction(Routes.HOME_ROUTE.name)
    }

    LoginScreen(
        state = state,
        onLoginAction = { action ->
            when (action) {
                is LoginActions.OnRedirectAction -> {
                    onRedirectAction(action.route)
                }

                else -> Unit
            }
            viewModel.onAction(action)
        }
    )
}

@Composable
fun LoginScreen(
    state: LoginState,
    onLoginAction: (LoginActions) -> Unit
) {
    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = Modifier.fillMaxSize()
            .background(VilaTheme.colors.background)
            .padding(VilaTheme.spaces.large),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            style = VilaTheme.typography.h1,
            text = stringResource(Res.string.vila_app_login_title)
        )

        Spacer(modifier = Modifier.padding(bottom = VilaTheme.spaces.medium))

        MainTextFieldEmail(
            value = state.emailField,
            hasError = state.errorMessage?.asString().orEmpty().isNotEmpty()
        ) {
            onLoginAction(LoginActions.OnFilledEmail(it))
        }

        Spacer(modifier = Modifier.padding(bottom = VilaTheme.spaces.medium))

        MainTextFieldPassword(
            value = state.passwordField,
            hasError = state.errorMessage?.asString().orEmpty().isNotEmpty()
        ) {
            onLoginAction(LoginActions.OnFilledPassword(it))
        }

        Spacer(modifier = Modifier.padding(bottom = VilaTheme.spaces.medium))

        LoadingButton(
            text = stringResource(Res.string.vila_app_login_button),
            onClick = {
                keyboardController?.hide()
                onLoginAction(LoginActions.OnLoginAction)
            },
            loading = state.inLoading,
        )

        Spacer(modifier = Modifier.padding(bottom = VilaTheme.spaces.medium))

        TextButton(
            onClick = {
                keyboardController?.hide()
                onLoginAction(LoginActions.OnRedirectAction(Routes.FORGOT_PASSWORD_ROUTE.name))

            }
        ) {
            Text(stringResource(Res.string.vila_app_forgot_pass_button))
        }
    }
}
