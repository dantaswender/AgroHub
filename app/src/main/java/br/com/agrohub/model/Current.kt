package br.com.agrohub.model
import com.google.gson.annotations.SerializedName


data class Current(
    @SerializedName("location")
    val location: Location?,
    @SerializedName("current")
    val current: CurrentX?
)

data class Location(
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

data class CurrentX(
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

data class Condition(
    @SerializedName("text")
    val text: String?,
    @SerializedName("icon")
    val icon: String?,
    @SerializedName("code")
    val code: Int?
)

data class AirQuality(
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