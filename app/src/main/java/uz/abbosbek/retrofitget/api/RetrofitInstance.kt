package uz.abbosbek.retrofitget.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.abbosbek.retrofitget.util.Constants.Companion.BASE_URL

object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api:SimpleApi by lazy {
        retrofit.create(SimpleApi::class.java)
    }
}