package br.com.gitpush.vilapp.ui.screens.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen

class LoginScreen(private val modifier: Modifier = Modifier) : Screen {

    @Composable
    override fun Content() {
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var enabledButton by remember { mutableStateOf(checkLogin(email, password)) }

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Login"
            )

            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = email,
                onValueChange = {
                    email = it
                },
                label = { Text("E-mail") })

            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = password,
                onValueChange = {
                    password = it
                },
                label = { Text("Senha") })

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = {},
                enabled = enabledButton
            ) {
                Text(text = "Acessar")
            }
        }
    }

    private fun checkLogin(email: String, password: String) =
        email.trim().isNotEmpty() && password.trim().isNotEmpty()
}
