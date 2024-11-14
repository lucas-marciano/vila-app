package br.com.gitpush.vilapp.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
data class CustomColors(
    val primary: Color,
    val onPrimary: Color,
    val text: Color,
    val background: Color,
    val onBackground: Color,
    val surface: Color,
    val onSurface: Color,
    val success: Color,
    val info: Color,
    val error: Color,
    val disable: Color,
    val onDisable: Color,
    val isLight: Boolean,
)
