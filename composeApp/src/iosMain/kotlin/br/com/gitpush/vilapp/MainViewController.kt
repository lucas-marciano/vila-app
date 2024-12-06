package br.com.gitpush.vilapp

import androidx.compose.ui.window.ComposeUIViewController
import br.com.gitpush.vilapp.core.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) {
    App()
}