package br.com.gitpush.vilapp.features.forgot_pass.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import br.com.gitpush.vilapp.ui.components.buttons.MainButton
import br.com.gitpush.vilapp.ui.components.textfields.MainTextFieldEmail
import br.com.gitpush.vilapp.ui.theme.VilaTheme
import org.jetbrains.compose.resources.stringResource
import vilapp.composeapp.generated.resources.Res
import vilapp.composeapp.generated.resources.vila_app_recovery_button

@Composable
fun ForgotPasswordRoute() {
    ForgotPasswordScreen()
}

@Composable
private fun ForgotPasswordScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
            .background(VilaTheme.colors.background)
            .padding(VilaTheme.spaces.large),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        MainTextFieldEmail(
            value = "",
        ) {
        }

        Spacer(modifier = Modifier.padding(bottom = VilaTheme.spaces.medium))

        MainButton(
            text = stringResource(Res.string.vila_app_recovery_button),
            onClick = {
            },
        )
    }
}
