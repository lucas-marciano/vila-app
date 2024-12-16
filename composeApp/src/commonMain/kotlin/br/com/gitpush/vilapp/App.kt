package br.com.gitpush.vilapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.com.gitpush.vilapp.core.presentation.Navigator
import br.com.gitpush.vilapp.ui.theme.VilaTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    VilaTheme {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = VilaTheme.colors.background)
        ) {
            Navigator()
        }
    }
}
