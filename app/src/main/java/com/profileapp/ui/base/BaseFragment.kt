package com.profileapp.ui.base

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.profileapp.countryapp.BaseActivity
import com.profileapp.utils.NetworkHelper
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

abstract  class BaseFragment<VM:BaseViewModel> (var compo:CompositeDisposable, networkHelper: NetworkHelper):
    Fragment() {

    @Inject
    lateinit var viewModel: VM


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    protected open fun setupObservers() {
        viewModel.messageString.observe(this, Observer {
            showMessage(it)
        })

        viewModel.messageStringId.observe(this, Observer {
            showMessage(it)
        })
    }


    fun showMessage(message: String) = context?.let { Toast.makeText(it, message, Toast.LENGTH_SHORT).show() }

    fun showMessage(@StringRes resId: Int) = showMessage(getString(resId))

    fun goBack() {
        if (activity is BaseActivity<*>) (activity as BaseActivity<*>).goBack()
    }


    @LayoutRes
    protected abstract fun provideLayoutId(): Int

//    protected abstract fun injectDependencies(fragmentComponent: FragmentComponent)

    protected abstract fun setupView(view: View)

}