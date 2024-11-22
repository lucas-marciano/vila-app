package br.com.gitpush.vilapp

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import br.com.gitpush.vilapp.theme.VilaTheme
import br.com.gitpush.vilapp.ui.navigation.Navigator
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    VilaTheme {
        Scaffold {
            Navigator(innerPadding = it)
        }
    }
}
