package br.com.gitpush.vilapp.core.data.ktor

import io.ktor.client.HttpClient
import io.ktor.client.request.HttpRequestBuilder

class KtorApiImpl: KtorApi {

    val prodUrl = "https://mainurl.dev/"

    override val client: HttpClient
        get() = TODO("Not yet implemented")

    override fun HttpRequestBuilder.apiUrl(path: String) {
        TODO("Not yet implemented")
    }

    override fun HttpRequestBuilder.json() {
        TODO("Not yet implemented")
    }
}
