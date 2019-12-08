package com.univem.firstapplication

import android.app.Application
import com.univem.firstapplication.di.apiModule
import com.univem.firstapplication.ui.gist.gistModule
import com.univem.firstapplication.ui.repository.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * @author Thiago Corredo
 * @since 2019-11-17
 */

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(
                listOf(
                    apiModule,
                    repositoryModule,
                    gistModule
                )
            )
        }
    }
}