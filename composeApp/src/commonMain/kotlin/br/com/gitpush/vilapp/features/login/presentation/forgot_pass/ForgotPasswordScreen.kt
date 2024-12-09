package br.com.gitpush.vilapp.features.login.presentation.forgot_pass

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import br.com.gitpush.vilapp.ui.components.buttons.MainButton
import br.com.gitpush.vilapp.ui.components.image.Logo
import br.com.gitpush.vilapp.ui.components.textfields.MainTextFieldEmail
import br.com.gitpush.vilapp.ui.theme.VilaTheme
import org.jetbrains.compose.resources.stringResource
import org.koin.compose.viewmodel.koinViewModel
import vilapp.composeapp.generated.resources.Res
import vilapp.composeapp.generated.resources.vila_app_forgot_pass_title
import vilapp.composeapp.generated.resources.vila_app_recovery_button

@Composable
fun ForgotPasswordRoute(
    viewModel: ForgotPassViewModel = koinViewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    ForgotPasswordScreen(state) { action ->
        viewModel.onAction(action)
    }
}

@Composable
private fun ForgotPasswordScreen(
    state: ForgotPassState,
    onRecoveryAction: (ForgotPassActions) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
            .background(VilaTheme.colors.background)
            .padding(VilaTheme.spaces.large),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Logo(
            modifier = Modifier
                .fillMaxWidth()
                .size(VilaTheme.spaces.imageSize)
        )

        Spacer(modifier = Modifier.padding(bottom = VilaTheme.spaces.large))

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(Res.string.vila_app_forgot_pass_title),
            color = VilaTheme.colors.text,
            style = VilaTheme.typography.h1
        )

        MainTextFieldEmail(
            value = state.emailField,
        ) { value ->
            onRecoveryAction(
                ForgotPassActions.OnFilledEmail(value)
            )
        }

        Spacer(modifier = Modifier.padding(bottom = VilaTheme.spaces.medium))

        MainButton(
            text = stringResource(Res.string.vila_app_recovery_button),
            onClick = {
                onRecoveryAction(
                    ForgotPassActions.OnRecoveryAction
                )
            },
        )

        Spacer(modifier = Modifier.padding(bottom = VilaTheme.spaces.large))

        if (state.errorMessage?.asString().orEmpty().isNotEmpty() || state.success) {
            Message(message = state.errorMessage?.asString().orEmpty(), isError = !state.success)
        }
    }
}

@Composable
private fun Message(message: String, isError: Boolean = true) {
    var visible by rememberSaveable { mutableStateOf(true) }

    AnimatedContent(visible) {
        if (visible) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = if (isError) VilaTheme.colors.error else VilaTheme.colors.success,
                        shape = VilaTheme.shapes.small
                    )
                    .padding(horizontal = 20.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.clickable {
                        visible = false
                    }
                )
                Text(
                    text = message,
                    color = Color.White,
                )
            }
        }
    }
}
