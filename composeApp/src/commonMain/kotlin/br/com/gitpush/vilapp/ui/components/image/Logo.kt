package br.com.gitpush.vilapp.ui.components.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import vilapp.composeapp.generated.resources.Res
import vilapp.composeapp.generated.resources.vila_app_login_title
import vilapp.composeapp.generated.resources.vila_app_main_logo

@Composable
fun Logo(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier,
        alignment = Alignment.Center,
        contentScale = ContentScale.Fit,
        painter = painterResource(Res.drawable.vila_app_main_logo),
        contentDescription = stringResource(Res.string.vila_app_login_title)
    )
}
