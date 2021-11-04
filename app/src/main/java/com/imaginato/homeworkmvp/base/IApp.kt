package com.imaginato.homeworkmvp.base

import android.app.Application
import com.imaginato.homeworkmvp.domain.apiModules
import com.imaginato.homeworkmvp.domain.databaseModule
import com.imaginato.homeworkmvp.domain.netModules
import com.imaginato.homeworkmvp.domain.repositoryModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class IApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@IApp)
            modules(
                databaseModule, netModules, apiModules, repositoryModules
            )
        }
    }
}