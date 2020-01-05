package com.profileapp.di.modules

import android.app.Application
import android.content.Context
import com.profileapp.ProfileApplicationClass
import com.profileapp.data.remote.network.NetworkClass
import com.profileapp.data.remote.network.NetworkServices
import com.profileapp.utils.NetworkHelper
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class ApplicationModule(val application: ProfileApplicationClass) {


    @Provides
    @Singleton
    fun provideApplication(): Application = application


    @Provides
    @Singleton
    fun provideContext(): Context = application


    @Provides
    fun provideCompositeDesposiable() = CompositeDisposable()


    @Provides
    @Singleton
    fun provideNetworkService(): NetworkServices =
        NetworkClass.create(
            "HBNA19QVVAPP",
            "https://api.projects.bootcamp.mindorks.com/batch/green/",
            application.cacheDir,
            10 * 1024 * 1024 // 10MB
    )


    @Singleton
    @Provides
    fun provideNetworkHelper(): NetworkHelper = NetworkHelper(application)
}