package com.shahriar.a11_pagination_class_30_to_32.api

import com.shahriar.a11_pagination_class_30_to_32.model.ResponseQuotes
import retrofit2.http.GET
import retrofit2.http.Query

interface QuotesApi {

    @GET("/quotes")
    suspend fun getAllQuotes(@Query("page") page: Int): ResponseQuotes
}