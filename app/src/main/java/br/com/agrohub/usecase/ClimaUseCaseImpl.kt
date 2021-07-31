package br.com.agrohub.usecase

import br.com.agrohub.repository.ClimaRepository

class ClimaUseCaseImpl(private val repository: ClimaRepository) : ClimaUseCase {
    override suspend fun getCurrenteClima(q: String, lang: String) =
        repository.getCurrenteClima(q, lang)
}