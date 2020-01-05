package com.profileapp.countryapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.lifecycle.Observer
import com.profileapp.ProfileApplicationClass
import com.profileapp.di.components.ActivityComponent
import com.profileapp.di.components.DaggerActivityComponent
import com.profileapp.di.modules.ActivityModule
import com.profileapp.ui.base.BaseViewModel
import javax.inject.Inject


//upper bound of BaseViewModel
abstract class BaseActivity<VM: BaseViewModel> : AppCompatActivity() {


    @Inject
    lateinit var  viewModel :VM

    override fun onCreate(savedInstanceState: Bundle?) {

        injectDependencies(buildApplicationComponent())
        super.onCreate(savedInstanceState)
        setContentView(provideLayoutId())
        setUpObserver()
        setUpView(savedInstanceState)
        viewModel.onCreate()
    }



    fun buildApplicationComponent() =  DaggerActivityComponent
            .builder()
            .activityModule(ActivityModule(this))
            .applicationComponent((application as ProfileApplicationClass).applicationComponent)
            .build()

    protected open  fun setUpObserver(){
        viewModel.messageString.observe(this, Observer {
            showMessage(it)
        })

        viewModel.messageStringId.observe(this, Observer {
            showMessage(it)
        })
    }


    fun showMessage(message: String) = Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    fun showMessage(@StringRes resId: Int){  showMessage(getString(resId)) }

    @LayoutRes
    protected  abstract fun provideLayoutId():Int

    protected abstract fun setUpView(savedInstanceState: Bundle?)

    open fun goBack() = onBackPressed()

    override fun onBackPressed() {
        if(supportFragmentManager.backStackEntryCount>0){
            supportFragmentManager.popBackStackImmediate()
        }else{
            super.onBackPressed()
        }
    }

    protected abstract  fun injectDependencies(activityComponent: ActivityComponent)
}
