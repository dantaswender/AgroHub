package br.com.dantaswender.mylibrary.data

class ResultApi<Success> {

    private constructor(value: Success) {
        this.value = value
    }

    private constructor(error: BadRequest) {
        this.erro = error
    }

    var value: Success? = null
    var erro: BadRequest? = null

    fun isSucesso() = value != null
    fun isErro() = erro != null

    companion object {
        fun <Success> createSuccess(value: Success) =
            ResultApi(value)
        fun <Error> createError(error: BadRequest) =
            ResultApi<Error>(error)
    }
}