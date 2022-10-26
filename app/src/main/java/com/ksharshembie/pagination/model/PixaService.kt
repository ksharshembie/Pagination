package com.ksharshembie.pagination.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class PixaService {
    val retrofit = Retrofit.Builder().baseUrl("https://pixabay.com/")
        .addConverterFactory(GsonConverterFactory.create()).build()

    fun getApi(): PixaApi {
        return retrofit.create(PixaApi::class.java)
    }
}