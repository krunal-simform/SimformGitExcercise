package simform.gitexcercise.android.ui.auth.register

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import simform.gitexcercise.android.data.model.RegisterDetail
import simform.gitexcercise.android.util.Validator

class RegisterViewModel : ViewModel() {

    val registerDetail = MutableStateFlow(RegisterDetail())

    fun validateDetails(): Boolean = with(registerDetail.value) {
        Validator.validateEmail(email) && password.isNotEmpty()
    }
}