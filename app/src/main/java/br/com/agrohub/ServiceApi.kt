package br.com.agrohub

import retrofit2.Call
import retrofit2.http.*

interface ServiceApi {

    @get:GET("")
    val getPrevisao: Call<Any>

}