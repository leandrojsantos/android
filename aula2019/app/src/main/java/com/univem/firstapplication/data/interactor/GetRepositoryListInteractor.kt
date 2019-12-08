package com.univem.firstapplication.data.interactor

import com.univem.firstapplication.data.local.Repository
import com.univem.firstapplication.data.local.ItemsResponse
import com.univem.firstapplication.data.remote.GitHubService
import retrofit2.Response

/**
 * @author Thiago Corredo
 * @since 2019-11-20
 */
class GetRepositoryListInteractor(private val gitHubService: GitHubService) {
    suspend fun execute(page: Int): Response<ItemsResponse<Repository>> =
        gitHubService.getRepositories(page)
}