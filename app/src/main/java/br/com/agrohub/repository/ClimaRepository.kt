package br.com.agrohub.repository

import br.com.agrohub.model.Current
import br.com.agrohub.model.Forecast
import br.com.dantaswender.mylibrary.data.ResultApi

interface ClimaRepository {
    suspend fun getCurrenteClima(q: String, lang: String): ResultApi<Forecast>
}