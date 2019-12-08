package com.univem.firstapplication.ui.gist

import com.univem.firstapplication.data.local.Gist

/**
 * @author Thiago Corredo
 * @since 2019-11-22
 */
sealed class GistViewState {

    data class Items(val repositories: List<Gist>) : GistViewState()

    object EmptyState : GistViewState()

    data class ShowError(val imageId: Int, val messageId: Int) : GistViewState()
}