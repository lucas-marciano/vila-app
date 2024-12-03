package br.com.gitpush.vilapp.ui.components.buttons

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.gitpush.vilapp.ui.theme.VilaTheme

@Composable
fun MainButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit = {},
    enabled: Boolean = false,
) {
    Button(
        shape = VilaTheme.shapes.medium,
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 4.dp,
            pressedElevation = 0.dp,
        ),
        colors = ButtonDefaults.buttonColors(
            containerColor = VilaTheme.colors.primary,
            contentColor = VilaTheme.colors.onPrimary,
            disabledContentColor = VilaTheme.colors.disable,
            disabledContainerColor = VilaTheme.colors.onDisable
        ),
        enabled = enabled,
        onClick = onClick,
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            modifier = Modifier.padding(vertical = 8.dp),
            text = text,
            style = VilaTheme.typography.button,
            color = VilaTheme.colors.onPrimary
        )
    }
}

@Composable
fun LoadingButton(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    enabled: Boolean = true,
    loading: Boolean = false,
) {
    Button(
        shape = VilaTheme.shapes.medium,
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 4.dp,
            pressedElevation = 0.dp,
        ),
        colors = ButtonDefaults.buttonColors(
            containerColor = VilaTheme.colors.primary,
            contentColor = VilaTheme.colors.onPrimary,
            disabledContentColor = VilaTheme.colors.disable,
            disabledContainerColor = VilaTheme.colors.onDisable
        ),
        enabled = enabled,
        onClick = {
            if (!loading) onClick()
        },
        modifier = modifier.fillMaxWidth()
    ) {
        Box(
            contentAlignment = Alignment.Center,
        ) {
            AnimatedContent(
                modifier = Modifier.padding(vertical = 8.dp),
                targetState = loading
            ) { showLoading ->
                if (showLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(20.dp),
                        strokeWidth = 2.dp,
                        color = VilaTheme.colors.onPrimary
                    )

                } else {
                    Text(
                        text = text,
                        style = VilaTheme.typography.button,
                        color = VilaTheme.colors.onPrimary
                    )
                }
            }
        }
    }
}
