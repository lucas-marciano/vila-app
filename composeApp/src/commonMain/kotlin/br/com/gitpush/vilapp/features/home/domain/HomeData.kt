package br.com.gitpush.vilapp.features.home.domain

data class HomeData(
    val name: String = "",
    val user: String = "",
    val function: String = "",
    val list: List<HomeMenus> = emptyList(),
)
