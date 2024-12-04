package br.com.gitpush.vilapp

import androidx.compose.ui.window.ComposeUIViewController
import io.ktor.client.engine.darwin.Darwin
import androidx.compose.runtime.remember

fun MainViewController() = ComposeUIViewController {
    App(
        engine = remember { Darwin.create() }
    )
}