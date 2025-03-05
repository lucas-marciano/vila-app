package br.com.gitpush.vilapp.features.home.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import br.com.gitpush.vilapp.ui.theme.VilaTheme
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import vilapp.composeapp.generated.resources.Res
import vilapp.composeapp.generated.resources.vila_app_ic_home_withe
import vilapp.composeapp.generated.resources.vila_app_login_title

@Composable
fun MainCardHome(
    modifier: Modifier = Modifier,
    residentName: String,
    residentType: String,
    condominiumName: String,
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardColors(
            containerColor = VilaTheme.colors.primary,
            contentColor = VilaTheme.colors.onPrimary,
            disabledContentColor = VilaTheme.colors.onPrimary,
            disabledContainerColor = VilaTheme.colors.primary,
        )
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(VilaTheme.spaces.small),
        ) {
            Text(
                modifier = Modifier.padding(start = 16.dp, top = 8.dp),
                text = condominiumName,
                color = VilaTheme.colors.onPrimary,
                style = VilaTheme.typography.h1
            )

            Row(
                modifier = Modifier.padding(start = 16.dp, top = 4.dp),
                horizontalArrangement = Arrangement.spacedBy(VilaTheme.spaces.large),
            ) {

                Image(
                    modifier = Modifier.size(40.dp),
                    alignment = Alignment.Center,
                    contentScale = ContentScale.Fit,
                    painter = painterResource(Res.drawable.vila_app_ic_home_withe),
                    contentDescription = stringResource(Res.string.vila_app_login_title)
                )

                Column(
                    verticalArrangement = Arrangement.spacedBy(VilaTheme.spaces.small)
                ) {
                    Text(
                        text = residentName,
                        color = VilaTheme.colors.onPrimary,
                        style = VilaTheme.typography.body1
                    )
                    Text(
                        text = residentType,
                        color = VilaTheme.colors.onPrimary,
                        style = VilaTheme.typography.body1
                    )
                }
            }
        }
    }
}
