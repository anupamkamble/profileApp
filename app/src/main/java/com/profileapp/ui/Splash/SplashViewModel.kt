package com.profileapp.ui.Splash

import androidx.lifecycle.MutableLiveData
import com.profileapp.ui.base.BaseViewModel
import com.profileapp.utils.NetworkHelper
import com.profileapp.utils.global.Event
import io.reactivex.disposables.CompositeDisposable


class SplashViewModel(compositeDisposable: CompositeDisposable, netWorkHelper: NetworkHelper) :

    BaseViewModel(compositeDisposable,netWorkHelper = netWorkHelper){


    // Event is used by the view model to tell the activity to launch another Activity
    // view model also provided the Bundle in the event that is needed for the Activity
    val launchMain: MutableLiveData<Event<Map<String, String>>> = MutableLiveData()
    val launchLogin: MutableLiveData<Event<Map<String, String>>> = MutableLiveData()



    override fun onCreate() {
        launchLogin.postValue(Event(emptyMap())) // if user is not login
    }

}