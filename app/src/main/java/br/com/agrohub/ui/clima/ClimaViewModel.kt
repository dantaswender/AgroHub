package br.com.agrohub.ui.clima

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ClimaViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is Clima Fragment"
    }
    val text: LiveData<String> = _text
}