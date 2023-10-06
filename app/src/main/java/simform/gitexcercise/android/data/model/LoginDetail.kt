package simform.gitexcercise.android.data.model

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import simform.gitexcercise.android.BR

data class LoginDetail(
    private var _email: String = "",
    private var _password: String = ""
) : BaseObservable() {

    @get:Bindable
    var email: String = _email
        set(value) {
            _email = value
            field = value
            notifyPropertyChanged(BR.email)
        }

    @get:Bindable
    var password: String = _password
        set(value) {
            _password = value
            field = value
            notifyPropertyChanged(BR.password)
        }
}
