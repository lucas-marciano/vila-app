package br.com.gitpush.vilapp

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import br.com.gitpush.vilapp.core.di.appModule
import br.com.gitpush.vilapp.ui.theme.VilaTheme
import br.com.gitpush.vilapp.core.presentation.Navigator
import io.ktor.client.engine.HttpClientEngine
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication

@Composable
@Preview
fun App(engine: HttpClientEngine) {
    KoinApplication(application = { modules(appModule()) }) {
        VilaTheme {
            Scaffold {
                Navigator(
                    engine = engine,
                    innerPadding = it
                )
            }
        }
    }
}
