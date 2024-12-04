package br.com.gitpush.vilapp.features.login.data.mappers

import br.com.gitpush.vilapp.features.login.data.dto.LoginDataDto
import br.com.gitpush.vilapp.features.login.domain.LoginData

fun LoginDataDto.toLoginData(): LoginData {
    return LoginData(
        id = id,
        name = name.orEmpty(),
        email = email.orEmpty(),
        type = type.orEmpty(),
        token = token.orEmpty()
    )
}