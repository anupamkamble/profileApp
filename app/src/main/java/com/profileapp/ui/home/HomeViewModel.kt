package com.profileapp.ui.home

import com.profileapp.ui.base.BaseViewModel
import com.profileapp.utils.NetworkHelper
import io.reactivex.disposables.CompositeDisposable


class HomeViewModel(var composite:CompositeDisposable, var network:NetworkHelper) : BaseViewModel(composite,network){



    override fun onCreate() {



    }


}