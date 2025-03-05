package br.com.gitpush.vilapp.features.home.domain

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.vector.ImageVector

@Immutable
data class HomeMenus(
    val id: Int = 0,
    val name: String = "",
    val icon: ImageVector = Icons.Default.Home,
    val action: (String) -> Unit = {},
)
