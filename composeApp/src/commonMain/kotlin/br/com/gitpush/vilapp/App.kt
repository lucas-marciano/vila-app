package br.com.gitpush.vilapp

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import br.com.gitpush.vilapp.core.presentation.Navigator
import br.com.gitpush.vilapp.ui.theme.VilaTheme
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
