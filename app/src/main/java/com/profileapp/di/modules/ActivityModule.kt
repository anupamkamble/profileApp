package com.profileapp.di.modules

import androidx.lifecycle.ViewModelProviders
import com.profileapp.countryapp.BaseActivity
import com.profileapp.data.remote.network.UserRepo
import com.profileapp.ui.Splash.SplashViewModel
import com.profileapp.ui.launcher.LauncherViewModel
import com.profileapp.ui.login.LoginViewModel
import com.profileapp.utils.NetworkHelper
import com.profileapp.utils.ViewModelFactoryProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable


@Module
class ActivityModule(private val activity: BaseActivity<*>) {

    @Provides
    fun provideMainViewModel(composite: CompositeDisposable, networkHelper: NetworkHelper)
            :LauncherViewModel = ViewModelProviders.of(
        activity,ViewModelFactoryProvider(LauncherViewModel::class){ LauncherViewModel(composite, networkHelper) }).get(LauncherViewModel::class.java)



    @Provides
    fun provideSplashViewModel(composite: CompositeDisposable, networkHelper: NetworkHelper)
            :SplashViewModel = ViewModelProviders.of(
        activity,ViewModelFactoryProvider(SplashViewModel::class){ SplashViewModel(composite, networkHelper) }).get(SplashViewModel::class.java)


    @Provides
    fun provideLoginViewModel(composite: CompositeDisposable, networkHelper: NetworkHelper, userRepo: UserRepo)
            : LoginViewModel = ViewModelProviders.of(
        activity,ViewModelFactoryProvider(LoginViewModel::class){ LoginViewModel(composite, networkHelper,userRepo) }).get(LoginViewModel::class.java)
}
