package com.univem.firstapplication.di

import com.univem.firstapplication.data.remote.BaseApi.createEndpoint
import com.univem.firstapplication.util.PagingManager
import org.koin.dsl.module

/**
 * @author Thiago Corredo
 * @since 2019-11-17
 */

val apiModule = module {
    single { createEndpoint() }
    factory { PagingManager() }
}
