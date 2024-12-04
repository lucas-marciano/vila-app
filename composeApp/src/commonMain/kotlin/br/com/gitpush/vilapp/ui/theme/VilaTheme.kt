package br.com.gitpush.vilapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf

object VilaTheme {

    val colors: CustomColors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current

    val typography: CustomTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalTypography.current

    val shapes: CustomShapes
        @Composable
        @ReadOnlyComposable
        get() = LocalShapes.current

    val spaces: CustomSpaces
        @Composable
        @ReadOnlyComposable
        get() = LocalSpaces.current

    private val LocalSpaces =
        staticCompositionLocalOf { CustomSpaces() }

    private val LocalShapes =
        staticCompositionLocalOf { CustomShapes() }

    private val LocalColors =
        staticCompositionLocalOf<CustomColors> { error("No CustomColors provided") }

    private val LocalTypography =
        staticCompositionLocalOf { CustomTypography() }

    @Composable
    operator fun invoke(
        darkTheme: Boolean = isSystemInDarkTheme(),
        content: @Composable () -> Unit
    ) {

        val colorScheme = when {
            darkTheme -> darkScheme
            else -> lightScheme
        }

        CompositionLocalProvider(
            LocalSpaces provides spaces,
            LocalShapes provides shapes,
            LocalColors provides lightScheme,
            LocalTypography provides typography,
        ) {
            content()
        }
    }
}
