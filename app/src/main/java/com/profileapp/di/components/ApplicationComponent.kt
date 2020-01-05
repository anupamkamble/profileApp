package com.profileapp.di.components

import android.content.Context
import com.profileapp.ProfileApplicationClass
import com.profileapp.data.remote.network.NetworkServices
import com.profileapp.data.remote.network.UserRepo
import com.profileapp.di.ApplicationContext
import com.profileapp.di.modules.ApplicationModule
import com.profileapp.utils.NetworkHelper
import dagger.Component
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: ProfileApplicationClass)

    fun getCompositeDisposable(): CompositeDisposable

    @ApplicationContext
    fun getContext(): Context


    fun getUserRepository(): UserRepo

    fun getNetWorkService(): NetworkServices

    fun getNetworkHelper(): NetworkHelper



}