package br.com.gitpush.vilapp.features.home.domain

import androidx.compose.runtime.Immutable

@Immutable
data class ListData(
    val id: Int = 0,
    val name: String = "",
    val details: String = "",
    val action: (Int) -> Unit = {},
)
