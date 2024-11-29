package br.com.gitpush.vilapp.core.domain.errors

class ErrorFieldException(private val customMessage: String = "") : Throwable() {

    override val message: String
        get() = if (customMessage.isEmpty())
            "NetworkErrorException: ${super.message}"
        else
            "NetworkErrorException: $customMessage"
}
