package simform.gitexcercise.android.ui.profile

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import simform.gitexcercise.android.data.model.ProfileDetail

class ProfileViewModel : ViewModel() {

    val profileDetail = MutableStateFlow(
        ProfileDetail("Krunal Patel", "test@simformsolutions.com", "Test@123")
    )
}