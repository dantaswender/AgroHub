package br.com.agrohub.usecase

import br.com.agrohub.model.Current
import br.com.agrohub.model.Forecast
import br.com.dantaswender.mylibrary.data.ResultApi

interface ClimaUseCase {
    suspend fun getCurrenteClima(q: String, lang: String): ResultApi<Forecast>
}