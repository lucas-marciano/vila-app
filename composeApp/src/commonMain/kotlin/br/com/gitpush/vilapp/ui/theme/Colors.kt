package br.com.gitpush.vilapp.ui.theme

import androidx.compose.ui.graphics.Color

private val disable = Color(0xFFCBCBCB)
private val onDisable = Color(0xFF5B5B5B)

private val primaryLight = Color(0xFF2164F3)
private val onPrimaryLight = Color(0xFFFFFFFF)
private val primaryContainerLight = Color(0xFF82A8EC)
private val onPrimaryContainerLight = Color(0xFF001C40)
private val secondaryLight = Color(0xFF515F79)
private val errorContainerLight = Color(0xFFFF1900)
private val backgroundLight = Color(0xFFF9F9FF)
private val onBackgroundLight = Color(0xFF1A1C20)
private val surfaceLight = Color(0xFFF9F9FF)
private val onSurfaceLight = Color(0xFF1A1C20)

val lightScheme = CustomColors(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    text = onPrimaryContainerLight,
    background = backgroundLight,
    onBackground = onBackgroundLight,
    surface = surfaceLight,
    onSurface = onSurfaceLight,
    success = secondaryLight,
    error = errorContainerLight,
    info = primaryContainerLight,
    disable = disable,
    onDisable = onDisable,
    isLight = true
)

private val primaryDark = Color(0xFFAAC7FF)
private val onPrimaryDark = Color(0xFF002F64)
private val primaryContainerDark = Color(0xFF6E94D6)
private val onPrimaryContainerDark = Color(0xFF000000)
private val secondaryDark = Color(0xFFB9C7E5)
private val errorContainerDark = Color(0xFF93000A)
private val backgroundDark = Color(0xFF121317)
private val onBackgroundDark = Color(0xFFE2E2E8)
private val surfaceDark = Color(0xFF121317)
private val onSurfaceDark = Color(0xFFE2E2E8)

val darkScheme = CustomColors(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    text = onPrimaryContainerDark,
    background = backgroundDark,
    onBackground = onBackgroundDark,
    surface = surfaceDark,
    onSurface = onSurfaceDark,
    success = secondaryDark,
    error = errorContainerDark,
    info = primaryContainerDark,
    disable = disable,
    onDisable = onDisable,
    isLight = false
)