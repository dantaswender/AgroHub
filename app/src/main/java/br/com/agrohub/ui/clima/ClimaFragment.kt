package br.com.agrohub.ui.clima

import android.Manifest
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.location.Address
import android.location.Geocoder
import android.location.LocationManager
import android.os.Bundle
import android.provider.Settings
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import br.com.agrohub.databinding.FragmentClimaBinding
import br.com.agrohub.model.Forecast
import br.com.dantaswender.PermissionUtils
import br.com.dantaswender.mylibrary.data.BadRequest
import com.google.android.gms.location.*
import com.squareup.picasso.Picasso
import kotlinx.coroutines.cancel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*


class ClimaFragment : Fragment() {

    private val climaViewModel: ClimaViewModel by viewModel()
    private var _binding: FragmentClimaBinding? = null

    private val binding get() = _binding!!

    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var locationRequest: LocationRequest
    private lateinit var locationCallback: LocationCallback

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentClimaBinding.inflate(inflater, container, false)

        val root: View = binding.root

        observe()
        checkLocation()
        return root
    }

    private fun observe() {
        climaViewModel.viewState.observe(viewLifecycleOwner, {
            when (it) {
                is MainState.IsSuccess -> {
                    showResultSuccess(it.success)
                }
                is MainState.IsError -> {
                    showResultError(it.error)
                }
                is MainState.IsLoading -> {
                    if (it.loading) {
                        binding.progressBar.visibility = VISIBLE
                    } else {
                        binding.progressBar.visibility = GONE
                    }
                }
            }
        })
    }

    private fun showResultError(error: BadRequest) {
    }

    private fun showResultSuccess(it: Forecast) {
        binding.tvLocation.text = "${it.location?.name} - ${it.location?.region}"
        binding.tvDay.text = it.location?.localtime
        binding.tvTemperature.text = it.current?.tempC.toString()
        binding.tvMaxMinTemperature.text =
            "${it.forecast?.forecastday?.first()?.day?.maxtempC.toString()} / " +
                    "${it.forecast?.forecastday?.first()?.day?.mintempC.toString()}"
        getIcon(it)
        binding.tvCondition.text = it.current?.forecastCondition?.text

    }

    private fun getIcon(it: Forecast) {
        var urlLogo = ""
        urlLogo = it.current?.forecastCondition?.icon.toString()
        val icon = binding.ivIcon
        Picasso.get().load("https://$urlLogo").into(icon)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun checkLocation() {
        val manager = requireContext().getSystemService(Context.LOCATION_SERVICE) as LocationManager
        if (!manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
            showAlertLocation()
        }
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity())
        getLocationUpdates()
    }

    private fun showAlertLocation() {
        val dialog = AlertDialog.Builder(requireContext())
        dialog.setMessage("Your location settings is set to Off, Please enable location to use this application")
        dialog.setPositiveButton("Settings") { _, _ ->
            val myIntent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
            startActivity(myIntent)
        }
        dialog.setNegativeButton("Cancel") { _, _ ->

        }
        dialog.setCancelable(false)
        dialog.show()
    }

    private fun getLocationUpdates() {
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity())
        locationRequest = LocationRequest()
        locationRequest.interval = 50000
        locationRequest.fastestInterval = 50000
        locationRequest.smallestDisplacement = 170f //170 m = 0.1 mile
        locationRequest.priority = LocationRequest.PRIORITY_HIGH_ACCURACY //according to your app
        locationCallback = object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult?) {
                locationResult ?: return
                if (locationResult.locations.isNotEmpty()) {
                    /*val location = locationResult.lastLocation
                    Log.e("location", location.toString())*/
                    val addresses: List<Address>?
                    val geoCoder = Geocoder(requireContext(), Locale.getDefault())
                    addresses = geoCoder.getFromLocation(
                        locationResult.lastLocation.latitude,
                        locationResult.lastLocation.longitude,
                        1
                    )
                    climaViewModel.getTemperature(
                        "${addresses.first().latitude},${addresses.first().longitude}"
                    )
                }
            }
        }
    }

    // Start location updates
    private fun startLocationUpdates() {

        val permission =
            PermissionUtils().checkPermission(
                requireActivity(),
                Manifest.permission.ACCESS_FINE_LOCATION
            )

        if (permission) {
            fusedLocationClient.requestLocationUpdates(
                locationRequest,
                locationCallback,
                null /* Looper */
            )
        } else {
            PermissionUtils().validate(
                requireActivity(),
                2,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
        }
    }

    private fun stopLocationUpdates() {
        fusedLocationClient.removeLocationUpdates(locationCallback)
    }

    override fun onPause() {
        super.onPause()
        stopLocationUpdates()
    }

    override fun onResume() {
        super.onResume()
        startLocationUpdates()
    }
}