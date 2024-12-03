package br.com.gitpush.vilapp

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import br.com.gitpush.vilapp.core.di.appModule
import br.com.gitpush.vilapp.ui.theme.VilaTheme
import br.com.gitpush.vilapp.core.presentation.Navigator
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication

@Composable
@Preview
fun App() {
    KoinApplication(application = { modules(appModule()) }) {
        VilaTheme {
            Scaffold {
                Navigator(innerPadding = it)
            }
        }
    }
}
