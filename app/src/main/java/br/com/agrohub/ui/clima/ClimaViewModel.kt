package br.com.agrohub.ui.clima

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.agrohub.model.Forecast
import br.com.agrohub.ui.BaseViewModel
import br.com.agrohub.usecase.ClimaUseCase
import br.com.dantaswender.mylibrary.data.BadRequest
import br.com.dantaswender.mylibrary.data.ResultApi
import kotlinx.coroutines.launch

class ClimaViewModel(private val useCase: ClimaUseCase) : BaseViewModel() {

    private val state: MutableLiveData<MainState> = MutableLiveData()
    val viewState: LiveData<MainState> = state

    fun getTemperature(q: String) {
        state.value = MainState.IsLoading(true)
        launch {
            val result = useCase.getCurrenteClima(
                q = q,
                lang = "pt"
            )
            onResponse(result)
        }
    }

    private fun onResponse(result: ResultApi<Forecast>) {
        if (result.isSucesso()) {
            state.value = result.value?.let { MainState.IsSuccess(it) }
        } else {
            state.value = result.erro?.let { MainState.IsError(it) }
        }
        state.value = MainState.IsLoading(false)
    }
}

sealed class MainState {
    data class IsSuccess(val success: Forecast) : MainState()
    data class IsError(val error: BadRequest) : MainState()
    data class IsLoading(val loading: Boolean) : MainState()
}