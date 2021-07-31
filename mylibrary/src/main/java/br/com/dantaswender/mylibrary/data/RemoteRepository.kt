package br.com.dantaswender.mylibrary.data

import com.google.gson.Gson
import retrofit2.Response

fun <T> doRequest(response: Response<T>): ResultApi<T> {
    return if (response.isSuccessful) {
        ResultApi.createSuccess(
            response.body()!!
        )
    } else {
        response.errorBody()?.let {
            val badRequest = Gson().fromJson(it.string(), BadRequest::class.java)
            ResultApi.createError(badRequest)
        }
            ?: run {
                ResultApi.createError(
                    BadRequest(
                        error = Error(
                            code = 0,
                            message = "Generic"
                        )
                    )
                )
            }
    }
}