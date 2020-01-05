package com.profileapp.utils.global

import com.coal.profileapp.R
import java.util.regex.Pattern

object Validator{

    private val EMAIL_ADDRESS = Pattern.compile(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
    )

    private const val MIN_PASSWORD_LENGTH = 6

    fun validateLoginFields(email:String?, password: String? ): ArrayList<Validation> =

        ArrayList<Validation>().apply {

            when{
                email.isNullOrBlank() ->  add(Validation(Validation.Field.EMAIL, Resources.error(R.string.email_field_empty)))
                !EMAIL_ADDRESS.matcher(email).matches() -> add(Validation(Validation.Field.EMAIL, Resources.error(R.string.email_field_invalid)))
                else ->     add(Validation(Validation.Field.EMAIL, Resources.success()))
            }
            when{
                password.isNullOrBlank() ->  add(Validation(Validation.Field.PASSWORD, Resources.error(R.string.password_field_empty)))

                password.length < MIN_PASSWORD_LENGTH -> add(Validation(Validation.Field.PASSWORD, Resources.error(R.string.password_field_small_length)))

                else ->   add(Validation(Validation.Field.PASSWORD, Resources.success()))

            }
        }

}


data class Validation(var field:Field, var resources: Resources<Int> ){

    enum class Field {
        EMAIL,
        PASSWORD
    }
}