package com.example.task.api

import com.example.task.models.FirstHits
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface HitsService {

    @GET("/search")
    suspend fun getHits(@Query("page") page : Int) : Response<FirstHits>
}