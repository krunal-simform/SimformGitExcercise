package simform.gitexcercise.android.ui.auth

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import simform.gitexcercise.android.R
import simform.gitexcercise.android.ui.auth.login.LoginFragment
import simform.gitexcercise.android.databinding.ActivityAuthBinding

class AuthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAuthBinding
    private val viewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAuthBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        setContentView(binding.root)
        setupUi()
    }

    private fun setupUi() {
        supportFragmentManager.commit {
            replace(R.id.container_view, LoginFragment())
        }
    }
}