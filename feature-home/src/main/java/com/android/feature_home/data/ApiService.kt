package com.android.feature_home.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {
    @GET
    suspend fun getHtmlContent(@Url url: String): Response<String>
}