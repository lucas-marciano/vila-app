package br.com.gitpush.vilapp.login.data.mappers

import br.com.gitpush.vilapp.login.data.dto.LoginDataDto
import br.com.gitpush.vilapp.login.domain.LoginData

fun LoginDataDto.toLoginData(): LoginData {
    return LoginData(
        id = id,
        name = name.orEmpty(),
        email = email.orEmpty(),
        type = type.orEmpty(),
        token = token.orEmpty()
    )
}