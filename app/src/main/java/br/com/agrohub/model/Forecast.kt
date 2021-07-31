package br.com.agrohub.model
import com.google.gson.annotations.SerializedName


/**
 * Created by Wender on 31,July,2021
 */
data class Forecast(
    @SerializedName("location")
    val location: ForecastLocation?,
    @SerializedName("current")
    val current: ForecastCurrent?,
    @SerializedName("forecast")
    val forecast: ForecastX?,
    @SerializedName("alerts")
    val alerts: Alerts?
)

data class ForecastLocation(
    @SerializedName("name")
    val name: String?,
    @SerializedName("region")
    val region: String?,
    @SerializedName("country")
    val country: String?,
    @SerializedName("lat")
    val lat: Double?,
    @SerializedName("lon")
    val lon: Double?,
    @SerializedName("tz_id")
    val tzId: String?,
    @SerializedName("localtime_epoch")
    val localtimeEpoch: Int?,
    @SerializedName("localtime")
    val localtime: String?
)

data class ForecastCurrent(
    @SerializedName("last_updated_epoch")
    val lastUpdatedEpoch: Int?,
    @SerializedName("last_updated")
    val lastUpdated: String?,
    @SerializedName("temp_c")
    val tempC: Double?,
    @SerializedName("temp_f")
    val tempF: Double?,
    @SerializedName("is_day")
    val isDay: Int?,
    @SerializedName("condition")
    val forecastCondition: ForecastCondition?,
    @SerializedName("wind_mph")
    val windMph: Double?,
    @SerializedName("wind_kph")
    val windKph: Double?,
    @SerializedName("wind_degree")
    val windDegree: Int?,
    @SerializedName("wind_dir")
    val windDir: String?,
    @SerializedName("pressure_mb")
    val pressureMb: Double?,
    @SerializedName("pressure_in")
    val pressureIn: Double?,
    @SerializedName("precip_mm")
    val precipMm: Double?,
    @SerializedName("precip_in")
    val precipIn: Double?,
    @SerializedName("humidity")
    val humidity: Int?,
    @SerializedName("cloud")
    val cloud: Int?,
    @SerializedName("feelslike_c")
    val feelslikeC: Double?,
    @SerializedName("feelslike_f")
    val feelslikeF: Double?,
    @SerializedName("vis_km")
    val visKm: Double?,
    @SerializedName("vis_miles")
    val visMiles: Double?,
    @SerializedName("uv")
    val uv: Double?,
    @SerializedName("gust_mph")
    val gustMph: Double?,
    @SerializedName("gust_kph")
    val gustKph: Double?,
    @SerializedName("air_quality")
    val forecastAirQuality: ForecastAirQuality?
)

data class ForecastX(
    @SerializedName("forecastday")
    val forecastday: List<Forecastday>?
)

data class Alerts(
    @SerializedName("alert")
    val alert: List<Any>?
)

data class ForecastCondition(
    @SerializedName("text")
    val text: String?,
    @SerializedName("icon")
    val icon: String?,
    @SerializedName("code")
    val code: Int?
)

data class ForecastAirQuality(
    @SerializedName("co")
    val co: Double?,
    @SerializedName("no2")
    val no2: Double?,
    @SerializedName("o3")
    val o3: Double?,
    @SerializedName("so2")
    val so2: Double?,
    @SerializedName("pm2_5")
    val pm25: Double?,
    @SerializedName("pm10")
    val pm10: Double?,
    @SerializedName("us-epa-index")
    val usEpaIndex: Int?,
    @SerializedName("gb-defra-index")
    val gbDefraIndex: Int?
)

data class Forecastday(
    @SerializedName("date")
    val date: String?,
    @SerializedName("date_epoch")
    val dateEpoch: Int?,
    @SerializedName("day")
    val day: Day?,
    @SerializedName("astro")
    val astro: Astro?,
    @SerializedName("hour")
    val hour: List<Hour>?
)

data class Day(
    @SerializedName("maxtemp_c")
    val maxtempC: Double?,
    @SerializedName("maxtemp_f")
    val maxtempF: Double?,
    @SerializedName("mintemp_c")
    val mintempC: Double?,
    @SerializedName("mintemp_f")
    val mintempF: Double?,
    @SerializedName("avgtemp_c")
    val avgtempC: Double?,
    @SerializedName("avgtemp_f")
    val avgtempF: Double?,
    @SerializedName("maxwind_mph")
    val maxwindMph: Double?,
    @SerializedName("maxwind_kph")
    val maxwindKph: Double?,
    @SerializedName("totalprecip_mm")
    val totalprecipMm: Double?,
    @SerializedName("totalprecip_in")
    val totalprecipIn: Double?,
    @SerializedName("avgvis_km")
    val avgvisKm: Double?,
    @SerializedName("avgvis_miles")
    val avgvisMiles: Double?,
    @SerializedName("avghumidity")
    val avghumidity: Double?,
    @SerializedName("daily_will_it_rain")
    val dailyWillItRain: Int?,
    @SerializedName("daily_chance_of_rain")
    val dailyChanceOfRain: String?,
    @SerializedName("daily_will_it_snow")
    val dailyWillItSnow: Int?,
    @SerializedName("daily_chance_of_snow")
    val dailyChanceOfSnow: String?,
    @SerializedName("condition")
    val condition: ConditionX?,
    @SerializedName("uv")
    val uv: Double?
)

data class Astro(
    @SerializedName("sunrise")
    val sunrise: String?,
    @SerializedName("sunset")
    val sunset: String?,
    @SerializedName("moonrise")
    val moonrise: String?,
    @SerializedName("moonset")
    val moonset: String?,
    @SerializedName("moon_phase")
    val moonPhase: String?,
    @SerializedName("moon_illumination")
    val moonIllumination: String?
)

data class Hour(
    @SerializedName("time_epoch")
    val timeEpoch: Int?,
    @SerializedName("time")
    val time: String?,
    @SerializedName("temp_c")
    val tempC: Double?,
    @SerializedName("temp_f")
    val tempF: Double?,
    @SerializedName("is_day")
    val isDay: Int?,
    @SerializedName("condition")
    val condition: ConditionXX?,
    @SerializedName("wind_mph")
    val windMph: Double?,
    @SerializedName("wind_kph")
    val windKph: Double?,
    @SerializedName("wind_degree")
    val windDegree: Int?,
    @SerializedName("wind_dir")
    val windDir: String?,
    @SerializedName("pressure_mb")
    val pressureMb: Double?,
    @SerializedName("pressure_in")
    val pressureIn: Double?,
    @SerializedName("precip_mm")
    val precipMm: Double?,
    @SerializedName("precip_in")
    val precipIn: Double?,
    @SerializedName("humidity")
    val humidity: Int?,
    @SerializedName("cloud")
    val cloud: Int?,
    @SerializedName("feelslike_c")
    val feelslikeC: Double?,
    @SerializedName("feelslike_f")
    val feelslikeF: Double?,
    @SerializedName("windchill_c")
    val windchillC: Double?,
    @SerializedName("windchill_f")
    val windchillF: Double?,
    @SerializedName("heatindex_c")
    val heatindexC: Double?,
    @SerializedName("heatindex_f")
    val heatindexF: Double?,
    @SerializedName("dewpoint_c")
    val dewpointC: Double?,
    @SerializedName("dewpoint_f")
    val dewpointF: Double?,
    @SerializedName("will_it_rain")
    val willItRain: Int?,
    @SerializedName("chance_of_rain")
    val chanceOfRain: String?,
    @SerializedName("will_it_snow")
    val willItSnow: Int?,
    @SerializedName("chance_of_snow")
    val chanceOfSnow: String?,
    @SerializedName("vis_km")
    val visKm: Double?,
    @SerializedName("vis_miles")
    val visMiles: Double?,
    @SerializedName("gust_mph")
    val gustMph: Double?,
    @SerializedName("gust_kph")
    val gustKph: Double?,
    @SerializedName("uv")
    val uv: Double?
)

data class ConditionX(
    @SerializedName("text")
    val text: String?,
    @SerializedName("icon")
    val icon: String?,
    @SerializedName("code")
    val code: Int?
)

data class ConditionXX(
    @SerializedName("text")
    val text: String?,
    @SerializedName("icon")
    val icon: String?,
    @SerializedName("code")
    val code: Int?
)