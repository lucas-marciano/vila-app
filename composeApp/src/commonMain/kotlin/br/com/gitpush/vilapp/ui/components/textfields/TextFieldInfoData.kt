package br.com.gitpush.vilapp.ui.components.textfields

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.vector.ImageVector

@Immutable
class TextFieldInfoData(
    val value: String,
    val placeholder: String,
    val enabled: Boolean = true,
    val icon: ImageVector? = null,
    val isError: Boolean = false,
)
