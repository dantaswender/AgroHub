package br.com.agrohub.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.agrohub.ui.BaseViewModel


class HomeViewModel : BaseViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment koin"
    }
    val text: LiveData<String> = _text
}