package com.profileapp.ui.Splash

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import com.coal.profileapp.R
import com.profileapp.countryapp.BaseActivity
import com.profileapp.di.components.ActivityComponent
import com.profileapp.ui.login.LoginActivity

class SplashActivity : BaseActivity<SplashViewModel>() {


    override fun provideLayoutId(): Int = R.layout.activity_splash


    override fun injectDependencies(activityComponent: ActivityComponent) { activityComponent.inject(this) }

    override fun setUpView(savedInstanceState: Bundle?) {}

    override fun setUpObserver() {
        super.setUpObserver()
        viewModel.launchLogin.observe(this, Observer {
            it.getIfNotHandled().let {
                startActivity(Intent(applicationContext, LoginActivity::class.java))
            }
        })
    }
}
