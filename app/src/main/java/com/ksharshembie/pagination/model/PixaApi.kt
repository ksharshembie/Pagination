package com.ksharshembie.pagination.model


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PixaApi {

    @GET("api/")
    fun getImages(
        @Query("key") key: String = "30851024-76847f5774724f4fc00dfbde7",
        @Query("q") keyWord: String,
        @Query("page") page: Int = 1,
        @Query("per_page") perPage: Int = 5
    ): Call<PixaModel>

}