package com.univem.firstapplication.ui.gist

import com.univem.firstapplication.data.interactor.GetGistListInteractor
import com.univem.firstapplication.data.interactor.GetRepositoryListInteractor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * @author Thiago Corredo
 * @since 2019-11-22
 */

val gistModule = module {
    factory { GetGistListInteractor(get()) }
    viewModel { GistViewModel(get()) }
}