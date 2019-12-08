package com.univem.firstapplication.data.interactor

import com.univem.firstapplication.data.local.Gist
import com.univem.firstapplication.data.remote.GitHubService
import retrofit2.Response

/**
 * @author Thiago Corredo
 * @since 2019-11-22
 */
class GetGistListInteractor(private val gitHubService: GitHubService) {
    suspend fun execute(): Response<List<Gist>> =
        gitHubService.getGists()
}