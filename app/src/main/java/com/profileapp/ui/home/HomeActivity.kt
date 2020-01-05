package com.profileapp.ui.home

import android.os.Bundle
import com.coal.profileapp.R
import com.profileapp.countryapp.BaseActivity
import com.profileapp.di.components.ActivityComponent


class HomeActivity : BaseActivity<HomeViewModel>(){



    override fun provideLayoutId() = R.layout.home_activity_layout


    override fun setUpView(savedInstanceState: Bundle?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun injectDependencies(activityComponent: ActivityComponent) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}