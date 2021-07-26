package br.com.agrohub.ui.clima

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import br.com.agrohub.R
import br.com.agrohub.databinding.FragmentClimaBinding

class ClimaFragment : Fragment() {

    private lateinit var climaViewModel: ClimaViewModel
    private var _binding: FragmentClimaBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // TODO mudar para injeção de dependencia
        climaViewModel = ViewModelProvider(this).get(ClimaViewModel::class.java)

        _binding = FragmentClimaBinding.inflate(inflater, container, false)

        val root: View = binding.root

        val textView: TextView = binding.tvClima
        climaViewModel.text.observe(viewLifecycleOwner, {
            textView.text = it
        })

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //viewModel = ViewModelProvider(this).get(ClimaViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}