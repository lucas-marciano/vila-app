package br.com.gitpush.vilapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
