package br.com.agrohub.di

import br.com.agrohub.repository.ClimaRepository
import br.com.agrohub.repository.ClimaRepositoryImpl
import br.com.agrohub.repository.ServiceApi
import br.com.agrohub.ui.clima.ClimaViewModel
import br.com.agrohub.ui.home.HomeViewModel
import br.com.agrohub.usecase.ClimaUseCase
import br.com.agrohub.usecase.ClimaUseCaseImpl
import br.com.dantaswender.mylibrary.RetrofitClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { HomeViewModel() }
}

val climaModule = module {

    val serviceApi: ServiceApi =
        RetrofitClient().createService("https://api.weatherapi.com")
            .create(ServiceApi::class.java)

    single<ClimaRepository> { ClimaRepositoryImpl(serviceApi) }
    single<ClimaUseCase> { ClimaUseCaseImpl(get()) }

    viewModel { ClimaViewModel(get()) }
}