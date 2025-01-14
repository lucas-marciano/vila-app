package br.com.gitpush.vilapp.features.home.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.gitpush.vilapp.features.home.presentation.HomeContract
import org.jetbrains.compose.resources.stringResource
import vilapp.composeapp.generated.resources.Res
import vilapp.composeapp.generated.resources.vila_app_message_exit_app

@Composable
fun ExitIcon(onAction: (HomeContract.Event) -> Unit) {
    Icon(
        modifier = Modifier.clickable {
            onAction(HomeContract.Event.OnRedirectAction("logout"))
        },
        imageVector = Icons.AutoMirrored.Filled.ExitToApp,
        contentDescription = stringResource(Res.string.vila_app_message_exit_app)
    )
}
