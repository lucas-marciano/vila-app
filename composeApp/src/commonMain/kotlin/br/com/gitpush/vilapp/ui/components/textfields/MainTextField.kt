package br.com.gitpush.vilapp.ui.components.textfields

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import br.com.gitpush.vilapp.ui.theme.VilaTheme
import org.jetbrains.compose.resources.stringResource
import vilapp.composeapp.generated.resources.Res
import vilapp.composeapp.generated.resources.vila_app_a11y_hide_pass
import vilapp.composeapp.generated.resources.vila_app_a11y_show_pass
import vilapp.composeapp.generated.resources.vila_app_email_label
import vilapp.composeapp.generated.resources.vila_app_password_label

@Composable
fun MainTextField(
    modifier: Modifier = Modifier,
    value: String = "",
    label: String = "",
    enabled: Boolean = true,
    icon: ImageVector? = null,
    hasError: Boolean = false,
    onValueChange: (String) -> Unit
) {

    var localValue by rememberSaveable { mutableStateOf(value) }
    TextFieldLocal {
        OutlinedTextField(
            modifier = modifier.fillMaxWidth()
                .minimumInteractiveComponentSize(),
            enabled = enabled,
            value = localValue,
            onValueChange = {
                localValue = it
                onValueChange(it)
            },
            singleLine = true,
            isError = hasError,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            label = { Text(text = label) },
            leadingIcon = icon?.let {
                { Icon(imageVector = it, contentDescription = null) }
            },
            colors = OutlinedTextFieldDefaults.colors(
                cursorColor = VilaTheme.colors.primary,
                focusedBorderColor = VilaTheme.colors.primary,
            )
        )
    }
}

@Composable
fun MainTextFieldEmail(
    modifier: Modifier = Modifier,
    value: String = "",
    enabled: Boolean = true,
    icon: ImageVector? = null,
    hasError: Boolean = false,
    onValueChange: (String) -> Unit
) {

    var localValue by rememberSaveable { mutableStateOf(value) }
    TextFieldLocal {
        OutlinedTextField(
            modifier = modifier.fillMaxWidth()
                .minimumInteractiveComponentSize(),
            enabled = enabled,
            value = localValue,
            onValueChange = {
                localValue = it
                onValueChange(it)
            },
            singleLine = true,
            isError = hasError,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            label = {
                Text(text = stringResource(Res.string.vila_app_email_label))
            },
            leadingIcon = icon?.let {
                { Icon(imageVector = it, contentDescription = null) }
            },
            colors = OutlinedTextFieldDefaults.colors(
                cursorColor = VilaTheme.colors.primary,
                focusedBorderColor = VilaTheme.colors.primary,
            )
        )
    }
}

@Composable
fun MainTextFieldPassword(
    modifier: Modifier = Modifier,
    value: String = "",
    enabled: Boolean = true,
    icon: ImageVector? = null,
    hasError: Boolean = false,
    onValueChange: (String) -> Unit
) {

    var localValue by rememberSaveable { mutableStateOf(value) }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    TextFieldLocal {
        OutlinedTextField(
            modifier = modifier.fillMaxWidth()
                .minimumInteractiveComponentSize(),
            enabled = enabled,
            value = localValue,
            onValueChange = {
                localValue = it
                onValueChange(it)
            },
            singleLine = true,
            isError = hasError,
            visualTransformation = if (passwordVisible)
                VisualTransformation.None
            else
                PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            label = {
                Text(text = stringResource(Res.string.vila_app_password_label))
            },
            leadingIcon = icon?.let {
                { Icon(imageVector = it, contentDescription = null) }
            },
            trailingIcon = {
                val image = if (passwordVisible)
                    Icons.Filled.VisibilityOff
                else
                    Icons.Filled.Visibility

                val description = if (passwordVisible)
                    stringResource(Res.string.vila_app_a11y_hide_pass)
                else
                    stringResource(Res.string.vila_app_a11y_show_pass)

                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(imageVector = image, contentDescription = description)
                }
            },
            colors = OutlinedTextFieldDefaults.colors(
                cursorColor = VilaTheme.colors.primary,
                focusedBorderColor = VilaTheme.colors.primary,
            )
        )
    }
}

@Composable
private fun TextFieldLocal(content: @Composable () -> Unit) {
    CompositionLocalProvider(
        LocalTextSelectionColors provides TextSelectionColors(
            handleColor = VilaTheme.colors.primary.copy(alpha = 0.66f),
            backgroundColor = VilaTheme.colors.primary.copy(alpha = 0.66f)
        )
    ) {
        content()
    }
}
