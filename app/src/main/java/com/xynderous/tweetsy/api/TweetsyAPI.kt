package com.xynderous.tweetsy.api

import com.xynderous.tweetsy.models.TweetListItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface TweetsyAPI {

    @GET("/v3/b/65567b0c0574da7622c7a1c6?meta=false")
    suspend fun getTweets(@Header("X-JSON-Path") category:String): Response<List<TweetListItem>>


    @GET("/v3/b/65567b0c0574da7622c7a1c6?meta=false")
    @Headers("X-JSON-Path: tweets..category")
    suspend fun getCategories():Response<List<String>>

}