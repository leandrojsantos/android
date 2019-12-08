package com.univem.firstapplication.data.remote

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * @author Thiago Corredo
 * @since 2019-11-17
 */
object BaseApi {
    fun createEndpoint(): GitHubService {
        return Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(MoshiConverterFactory.create(MoshiFactory.get()))
            .build()
            .create(GitHubService::class.java)
    }
}
