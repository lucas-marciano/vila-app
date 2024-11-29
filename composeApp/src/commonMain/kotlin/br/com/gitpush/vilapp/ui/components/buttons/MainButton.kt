package br.com.gitpush.vilapp.ui.components.buttons

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import br.com.gitpush.vilapp.ui.theme.VilaTheme

private const val TIME_ANIMATION_DURATION = 3000
private const val ALPHA = 0.5f

@Composable
fun MainButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit = {},
    enabled: Boolean = false,
    loading: Boolean = false
) {

//    val interactionSource = remember { MutableInteractionSource() }
//    val isPressed by interactionSource.collectIsPressedAsState()
//    val buttonColor by animateColorAsState(
//        targetValue = if (isPressed) Color.Red else Color.Blue
//    )
//
//    Box(
//        modifier = Modifier
//            .fillMaxWidth()
//            .clip(RoundedCornerShape(8.dp))
//            .background(buttonColor)
//            .clickable(
//                interactionSource = interactionSource,
//                indication = null
//            ) { onClick() },
//        contentAlignment = Alignment.Center
//    ) {
//        Text(
//            modifier = Modifier.padding(vertical = 16.dp),
//            text = text,
//            style = VilaTheme.typography.button,
//            color = VilaTheme.colors.onPrimary
//        )
//    }

    val isEnabled by remember { mutableStateOf(enabled) }
    val isLoading by remember { mutableStateOf(loading) }

    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val animatedBgColor by animateColorAsState(
        targetValue = if (isPressed) Color.Red else VilaTheme.colors.primary,
        label = "bg color"
    )
    val animatedContentColor by animateColorAsState(
        targetValue = if (isPressed) VilaTheme.colors.onPrimary.copy(.6f) else VilaTheme.colors.onPrimary,
        label = "content color"
    )

    Button(
        modifier = modifier.fillMaxWidth(),
        enabled = isEnabled,
        onClick = { onClick() },
        elevation = ButtonDefaults.elevation(),
        interactionSource = interactionSource,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = animatedBgColor,
            contentColor = animatedContentColor,
            disabledBackgroundColor = VilaTheme.colors.primary.copy(alpha = ALPHA),
            disabledContentColor = VilaTheme.colors.onPrimary.copy(alpha = ALPHA)
        ),
        shape = VilaTheme.shapes.medium,
    ) {
        Text(
            text = text,
            style = VilaTheme.typography.button,
            color = animatedContentColor
        )
    }
}
