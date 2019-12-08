package com.univem.firstapplication.ui.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.univem.firstapplication.R
import com.univem.firstapplication.data.interactor.GetRepositoryListInteractor
import com.univem.firstapplication.data.local.Repository
import com.univem.firstapplication.util.PagingManager
import kotlinx.coroutines.launch

/**
 * @author Thiago Corredo
 * @since 2019-11-20
 */
class RepositoryViewModel(
    private val getRepositoryListInteractor: GetRepositoryListInteractor,
    private val pagingManager: PagingManager
) : ViewModel() {

    private val _viewState = MutableLiveData<RepositoryViewState>()
    val viewState: LiveData<RepositoryViewState> = _viewState

    private var repositories: List<Repository> = emptyList()

    fun getRepositories() {
        viewModelScope.launch {
            try {
                if (pagingManager.nextPage != 1 && !pagingManager.hasMore()) {
                    return@launch
                }

                val response = getRepositoryListInteractor.execute(pagingManager.nextPage)

                if (response.isSuccessful) {
                    pagingManager.savePageHeader(response.headers())
                    response.body()?.response?.let {
                        if (it.isEmpty()) {
                            _viewState.value =
                                RepositoryViewState.EmptyState
                        } else {
                            repositories = repositories + it
                            _viewState.value =
                                RepositoryViewState.Items(repositories)
                        }
                    }
                } else {
                    _viewState.value =
                        RepositoryViewState.ShowError(
                            R.drawable.ic_error_gray_72dp,
                            R.string.api_error
                        )
                }
            } catch (exception: Throwable) {
                _viewState.value =
                    RepositoryViewState.ShowError(
                        R.drawable.ic_signal_wifi_off_gray_72dp,
                        R.string.network_error
                    )
            }
        }
    }
}