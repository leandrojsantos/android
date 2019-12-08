package com.univem.firstapplication.ui.repository

import com.univem.firstapplication.data.interactor.GetRepositoryListInteractor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * @author Thiago Corredo
 * @since 2019-11-20
 */

val repositoryModule = module {
    factory { GetRepositoryListInteractor(get()) }
    viewModel { RepositoryViewModel(get(), get()) }
}