package com.univem.firstapplication.ui.gist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.univem.firstapplication.R
import com.univem.firstapplication.data.interactor.GetGistListInteractor
import kotlinx.coroutines.launch

/**
 * @author Thiago Corredo
 * @since 2019-11-20
 */
class GistViewModel(private val getGistListInteractor: GetGistListInteractor) : ViewModel() {

    private val _viewState = MutableLiveData<GistViewState>()
    val viewState : LiveData<GistViewState> = _viewState

    fun getGists() {
        viewModelScope.launch {
            try {
                val response = getGistListInteractor.execute()

                if (response.isSuccessful) {
                    response.body()?.let {
                        if (it.isEmpty()) {
                            _viewState.value =
                                GistViewState.EmptyState
                        } else {
                            _viewState.value =
                                GistViewState.Items(it)
                        }
                    }
                } else {
                    _viewState.value =
                        GistViewState.ShowError(
                            R.drawable.ic_error_gray_72dp,
                            R.string.api_error
                        )
                }
            } catch (exception: Throwable) {
                _viewState.value =
                    GistViewState.ShowError(
                        R.drawable.ic_signal_wifi_off_gray_72dp,
                        R.string.network_error
                    )
            }
        }
    }
}