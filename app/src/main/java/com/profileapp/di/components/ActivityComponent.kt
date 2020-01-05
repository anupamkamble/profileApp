package com.profileapp.di.components
import com.profileapp.di.ActivityScope
import com.profileapp.di.modules.ActivityModule
import com.profileapp.ui.Splash.SplashActivity
import com.profileapp.ui.launcher.LauncherActivity
import com.profileapp.ui.login.LoginActivity
import dagger.Component


@ActivityScope
@Component(
    modules = [ActivityModule::class],
    dependencies = [ApplicationComponent::class])
interface ActivityComponent {

    fun inject(acivity : LauncherActivity)

    fun inject (activity: SplashActivity)

    fun inject (activity: LoginActivity)

}
