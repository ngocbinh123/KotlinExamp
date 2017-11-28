package com.dou.kotlinexam.webApi

import com.dou.kotlinexam.model.ChannelListResponse
import com.google.gson.GsonBuilder
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * Created by nnbinh on 11/27/17.
 */
interface APIService {
    companion object {
        fun create(): APIService {
            val retrofit = Retrofit.Builder()
                    .baseUrl("http://ams-api.astro.com.my/ams/v3/")
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(GsonBuilder()
                            .setLenient()
                            .serializeNulls()
                            .create()))
                    .build()
            return retrofit.create(APIService::class.java)
        }
    }

    @GET("getChannelList")
    fun getChannelList(): Observable<ChannelListResponse>
}