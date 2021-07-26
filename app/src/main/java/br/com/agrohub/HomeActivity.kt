package br.com.agrohub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.findNavController
import br.com.agrohub.ui.main.HomeFragment

class HomeActivity : AppCompatActivity() {

    private val controlador by lazy {
        findNavController(R.id.nav_host_fragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)
        if (savedInstanceState == null) {
            Handler(Looper.getMainLooper()).postDelayed({
                controlador.navigate(R.id.homeFragment)
            }, 500)
        }
    }
}