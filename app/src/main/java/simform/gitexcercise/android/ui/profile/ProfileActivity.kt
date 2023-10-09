package simform.gitexcercise.android.ui.profile

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import simform.gitexcercise.android.R
import simform.gitexcercise.android.databinding.ActivityProfileBinding
import simform.gitexcercise.android.ui.profile.viewprofile.ViewProfileFragment

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding
    private val viewModel: ProfileViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProfileBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        setContentView(binding.root)
        setupUI()
    }

    private fun setupUI() {
        supportFragmentManager.commit {
            replace(R.id.container_view_profile, ViewProfileFragment())
        }
    }
}