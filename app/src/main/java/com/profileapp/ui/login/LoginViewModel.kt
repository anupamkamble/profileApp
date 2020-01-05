package com.profileapp.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.profileapp.data.remote.network.UserRepo
import com.profileapp.ui.base.BaseViewModel
import com.profileapp.utils.NetworkHelper
import com.profileapp.utils.global.*
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class LoginViewModel(compositeDisposable: CompositeDisposable,
                     netWorkHelper: NetworkHelper, val userRepo: UserRepo) :
    BaseViewModel(compositeDisposable,netWorkHelper = netWorkHelper
){

    val launchMain: MutableLiveData<Event<Map<String, String>>> = MutableLiveData()

    private val validationsList: MutableLiveData<List<Validation>> = MutableLiveData()



    val emailField : MutableLiveData<String> = MutableLiveData()
    val passwordField : MutableLiveData<String>  = MutableLiveData()
    val loggedIn : MutableLiveData<Boolean> = MutableLiveData()

    val emailValidation: LiveData<Resources<Int>> = filterValidation(Validation.Field.EMAIL)
    val passwordValidation: LiveData<Resources<Int>> = filterValidation(Validation.Field.PASSWORD)


    private fun filterValidation(filed : Validation.Field) =
        Transformations.map(validationsList){
            it.find { validation ->  filed == validation.field }
                ?.run { return@run this.resources}
                ?: Resources.unknown(null)
    }


    override fun onCreate() {}

    fun onEmailChange(email: String) = emailField.postValue(email)

    fun onPassWordChange(password: String) = passwordField.postValue(password)

    fun onLogin(){

        val email = emailField.value
        val password = passwordField.value

        val validation = Validator.validateLoginFields(email, password)
        validationsList.postValue(validation)

        if(validation.isNotEmpty() && email!= null && password != null){

            val sucessValidation = validation.filter { it.resources.status == Status.SUCCESS }

            if (sucessValidation.size == validation.size && checkInterNetConnection()){

                loggedIn.postValue(true)

                compositeDisposable.add(

                    userRepo.doLogin(email,password)
                        .subscribeOn(Schedulers.io())
                        .subscribe (

                            {

                                loggedIn.postValue(false)
                                launchMain.postValue(Event(emptyMap()))

                            },
                            {
                                //handleError
                                loggedIn.postValue(false)


                            }
                        )


                )
            }





        }




    }


}