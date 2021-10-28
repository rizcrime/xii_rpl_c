package learn.idn.basicandroid.network

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class Config {

    fun retrofit(): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://api.alquran.cloud/v1/surah/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun service() = retrofit().create(getService::class.java)

}

interface getService {
    @GET("114")
    fun listRepos(): Call<AlquranModel>
}