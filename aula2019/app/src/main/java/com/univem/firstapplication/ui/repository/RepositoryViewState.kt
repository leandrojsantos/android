package com.univem.firstapplication.ui.repository

import com.univem.firstapplication.data.local.Repository

/**
 * @author Thiago Corredo
 * @since 2019-11-20
 */
sealed class RepositoryViewState {

    data class Items(val repositories: List<Repository>) : RepositoryViewState()

    object EmptyState : RepositoryViewState()

    data class ShowError(val imageId: Int, val messageId: Int) : RepositoryViewState()
}