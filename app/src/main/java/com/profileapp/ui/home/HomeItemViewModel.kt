package com.profileapp.ui.home

import com.profileapp.ui.base.BaseItemViewModel
import com.profileapp.ui.home.homePojo.HomeContent
import com.profileapp.utils.NetworkHelper
import io.reactivex.disposables.CompositeDisposable


class HomeItemViewModel(var compo:CompositeDisposable, var net: NetworkHelper) : BaseItemViewModel<HomeContent>(compo, net){


    override fun onCreate() {

        //TODO

    }


}