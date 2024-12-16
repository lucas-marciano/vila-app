package br.com.gitpush.vilapp.ui.components.topbar

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.ktor.websocket.Frame

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopBar(
    modifier: Modifier = Modifier,
    title: String,
    navIcon: (@Composable () -> Unit)? = null,
    actionIcon: (@Composable () -> Unit)? = null
) {
    TopAppBar(
        modifier = modifier,
        title = {
            Frame.Text(title)
        },
        navigationIcon = {
            navIcon?.let {
                navIcon()
            }
        },
        actions = {
            actionIcon?.let {
                actionIcon()
            }
        }
    )
}