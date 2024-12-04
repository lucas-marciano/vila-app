package br.com.gitpush.vilapp.features.login.domain

data class LoginData(
    var id: String = "",
    var name: String = "",
    var email: String = "",
    var type: String = "",
    var token: String = "",
)
