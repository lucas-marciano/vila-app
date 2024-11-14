package br.com.gitpush.vilapp

import androidx.compose.runtime.Composable
import br.com.gitpush.vilapp.theme.VilaTheme
import br.com.gitpush.vilapp.ui.screens.login.LoginScreen
import cafe.adriel.voyager.navigator.Navigator
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    VilaTheme {
        Navigator(LoginScreen())
    }
}
