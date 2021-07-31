package br.com.agrohub.repository

import br.com.agrohub.model.Current
import br.com.agrohub.model.Forecast
import br.com.dantaswender.mylibrary.data.ResultApi
import br.com.dantaswender.mylibrary.data.doRequest
import retrofit2.awaitResponse

class ClimaRepositoryImpl(private val serviceApi: ServiceApi) : ClimaRepository {
    override suspend fun getCurrenteClima(q: String, lang: String): ResultApi<Forecast> {
        return doRequest(
            serviceApi.getCurrent(
                q = q, lang = lang
            ).awaitResponse()
        )
    }
}