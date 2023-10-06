package simform.gitexcercise.android.ui.auth.forgotpassword

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import simform.gitexcercise.android.util.Validator

class ForgotPasswordViewModel : ViewModel() {

    val email = MutableStateFlow("")

    fun validateEmail(): Boolean = Validator.validateEmail(email.value)
}