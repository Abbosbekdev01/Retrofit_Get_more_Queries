package uz.abbosbek.retrofitget.api

import okhttp3.Interceptor
import okhttp3.Response

class MyInterceptor:Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("Content-Type", "application/json")
            .addHeader("X- platform", "Android")
            .addHeader("X-Auth-Token", "12345679")
            .build()

        return chain.proceed(request)
    }
}