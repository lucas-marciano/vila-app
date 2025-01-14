package br.com.gitpush.vilapp.features.home.domain

import androidx.compose.ui.graphics.vector.ImageVector

data class HomeMenus(
    val name: String,
    val icon: ImageVector,
    val action: () -> Unit = {}
)
