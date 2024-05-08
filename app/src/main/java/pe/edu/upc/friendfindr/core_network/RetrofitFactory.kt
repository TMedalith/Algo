package pe.edu.upc.friendfindr.core_network

import pe.edu.upc.friendfindr.core_network.ApiClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory private constructor() {
    companion object {
        fun getRetrofit(): Retrofit {
            return Retrofit
                .Builder()
                .baseUrl(ApiClient.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }

}