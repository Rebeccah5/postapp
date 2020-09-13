package api

import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object apiclient {
    var client:OkHttpClient=OkHttpClient.Builder().build()
    var retrofit= Retrofit.Builder()
        .baseUrl("")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
    fun <T> buildService(service: Class<T>): T {
        return retrofit.create(service)
    }
}







