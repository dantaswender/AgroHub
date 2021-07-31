package br.com.dantaswender.mylibrary.data

import com.google.gson.annotations.SerializedName

data class BadRequest(
    @SerializedName("error")
    val error: Error?
)

data class Error(
    @SerializedName("code")
    val code: Int?,
    @SerializedName("message")
    val message: String?
)