package simform.gitexcercise.android.util

import android.util.Patterns

object Validator {

    fun validateEmail(email: String): Boolean {
        val pattern = Patterns.EMAIL_ADDRESS
        return pattern.matcher(email).matches()
    }
}