package simform.gitexcercise.android.ui.auth.login

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import simform.gitexcercise.android.data.model.LoginDetail

class LoginViewModel : ViewModel() {

    val loginDetail = MutableStateFlow(LoginDetail())

    fun validateDetails(): Boolean =
        loginDetail.value.email == EMAIL && loginDetail.value.password == PASSWORD

    companion object {
        private const val EMAIL = "test@simformsolutions.com"
        private const val PASSWORD = "Test@123"
    }
}