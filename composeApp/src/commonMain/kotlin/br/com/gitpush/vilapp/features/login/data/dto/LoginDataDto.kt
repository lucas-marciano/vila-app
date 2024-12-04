package br.com.gitpush.vilapp.features.login.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LoginDataDto(
    @SerialName("id") val id: String,
    @SerialName("name") val name: String?,
    @SerialName("email") val email: String?,
    @SerialName("type") val type: String?,
    @SerialName("token") val token: String?,
)
