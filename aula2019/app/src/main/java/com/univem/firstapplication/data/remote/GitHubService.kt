package com.univem.firstapplication.data.remote

import com.univem.firstapplication.data.local.Gist
import com.univem.firstapplication.data.local.Repository
import com.univem.firstapplication.data.local.ItemsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author Thiago Corredo
 * @since 2019-11-17
 */
interface GitHubService {
    @GET("search/repositories?q=language:Java&sort=stars")
    suspend fun getRepositories(@Query("page") page: Int): Response<ItemsResponse<Repository>>

    @GET("gists/public")
    suspend fun getGists(): Response<List<Gist>>
}