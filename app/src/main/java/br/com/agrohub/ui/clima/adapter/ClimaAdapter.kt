package br.com.agrohub.ui.clima.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import br.com.agrohub.R
import br.com.agrohub.model.Forecastday

/**
 * Created by Wender on 31,July,2021
 */
class ClimaAdapter(
    val context: Context,
    private val forecastDay: List<Forecastday>,
    private val language: String
) : RecyclerView.Adapter<ClimaAdapter.ListViewHolder>() {

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvItemDay: AppCompatTextView by lazy {
            itemView.findViewById(R.id.tv_item_day)
        }

        private val tvItemTemperature: AppCompatTextView by lazy {
            itemView.findViewById(R.id.tv_item_temperature)
        }

        fun vincula(forecastday: Forecastday, language: String) {
            preencheCampo(forecastday, language)
        }

        private fun preencheCampo(forecastday: Forecastday, language: String) {
            tvItemDay.text = forecastday.date
            tvItemTemperature.text = if (language.equals("pt", true)) {
                "Max: ${forecastday.day?.maxtempC.toString()}ºC / Min: ${forecastday.day?.mintempC.toString()}ºC"
            } else {
                "Max: ${forecastday.day?.maxtempF.toString()}ºF / Min: ${forecastday.day?.mintempF.toString()}ºF"
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val inflate = LayoutInflater.from(context).inflate(R.layout.item_days, parent, false)
        return ListViewHolder(inflate)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.vincula(forecastDay[position], language)
    }

    override fun getItemCount() = forecastDay.size
}