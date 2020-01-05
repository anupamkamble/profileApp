package com.profileapp.ui.launcher

import android.os.Bundle
import com.coal.profileapp.R
import com.profileapp.countryapp.BaseActivity
import com.profileapp.di.components.ActivityComponent


class LauncherActivity : BaseActivity<LauncherViewModel>(){


    override fun provideLayoutId() = R.layout.activity_main


    override fun injectDependencies(activityComponent: ActivityComponent)  = activityComponent.inject(this)

    override fun setUpView(savedInstanceState: Bundle?) {
        //TODO:: after setting up view
    }
}