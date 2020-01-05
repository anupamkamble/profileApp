package com.profileapp.ui.launcher

import androidx.lifecycle.MutableLiveData
import com.profileapp.ui.base.BaseViewModel
import com.profileapp.utils.NetworkHelper
import io.reactivex.disposables.CompositeDisposable


class LauncherViewModel(var composite: CompositeDisposable, networkHelper: NetworkHelper) : BaseViewModel(composite,networkHelper){



    val testData = MutableLiveData<String>()

    override fun onCreate() {
        testData.postValue("hello from main View modek")
    }
}