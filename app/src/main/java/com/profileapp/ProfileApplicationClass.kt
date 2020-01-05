package com.profileapp

import android.app.Application
import com.profileapp.di.components.ApplicationComponent
import com.profileapp.di.components.DaggerApplicationComponent
import com.profileapp.di.modules.ApplicationModule


class ProfileApplicationClass: Application() {


    lateinit var  applicationComponent : ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent =  DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()

        applicationComponent.inject(ProfileApplicationClass@this)

    }

    fun setComponent(applicationComponent: ApplicationComponent) {
        this.applicationComponent = applicationComponent
    }


}