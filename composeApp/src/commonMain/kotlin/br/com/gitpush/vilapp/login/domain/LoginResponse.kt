package br.com.gitpush.vilapp.login.domain

data class LoginResponse(
    var id: String = "",
    var name: String = "",
    var email: String = "",
    var type: String = "",
    var token: String = "",
)
