package br.com.gitpush.vilapp.ui.components.textfields

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun MainTextField(
    modifier: Modifier = Modifier,
    data: TextFieldInfoData,
    onValueChange: (String) -> Unit
) {

    var localValue by rememberSaveable { mutableStateOf(data.value) }

    TextField(
        modifier = modifier.fillMaxWidth(),
        enabled = data.enabled,
        value = localValue,
        onValueChange = {
            localValue = it
            onValueChange(it)
        },
        singleLine = true,
        isError = data.isError,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        placeholder = {
            Text(text = data.placeholder)
        },
        leadingIcon = data.icon?.let {
            { Icon(imageVector = it, contentDescription = null) }
        }
    )
}

@Composable
fun MainTextFieldEmail(
    modifier: Modifier = Modifier,
    data: TextFieldInfoData,
    onValueChange: (String) -> Unit
) {

    var localValue by rememberSaveable { mutableStateOf(data.value) }

    TextField(
        modifier = modifier.fillMaxWidth(),
        enabled = data.enabled,
        value = localValue,
        onValueChange = {
            localValue = it
            onValueChange(it)
        },
        singleLine = true,
        isError = data.isError,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        placeholder = {
            Text(text = data.placeholder)
        },
        leadingIcon = data.icon?.let {
            { Icon(imageVector = it, contentDescription = null) }
        }
    )
}

@Composable
fun MainTextFieldPassword(
    modifier: Modifier = Modifier,
    data: TextFieldInfoData,
    onValueChange: (String) -> Unit
) {

    var localValue by rememberSaveable { mutableStateOf(data.value) }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }


    TextField(
        modifier = modifier.fillMaxWidth(),
        enabled = data.enabled,
        value = localValue,
        onValueChange = {
            localValue = it
            onValueChange(it)
        },
        singleLine = true,
        isError = data.isError,
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        placeholder = {
            Text(text = data.placeholder)
        },
        leadingIcon = data.icon?.let {
            { Icon(imageVector = it, contentDescription = null) }
        },
        trailingIcon = {
            val image = if (passwordVisible)
                Icons.Filled.Edit
            else
                Icons.AutoMirrored.Filled.Send

            val description = if (passwordVisible) "Hide password" else "Show password"

            IconButton(onClick = {passwordVisible = !passwordVisible}){
                Icon(imageVector  = image, description)
            }
        }
    )
}