package simform.gitexcercise.android.ui.auth.forgotpassword

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import simform.gitexcercise.android.R
import simform.gitexcercise.android.databinding.FragmentForgotPasswordBinding
import simform.gitexcercise.android.databinding.FragmentLoginBinding
import simform.gitexcercise.android.ui.auth.login.LoginFragment
import simform.gitexcercise.android.ui.auth.register.RegisterFragment

class ForgotPasswordFragment : Fragment() {

    private lateinit var binding: FragmentForgotPasswordBinding
    private val viewModel: ForgotPasswordViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentForgotPasswordBinding.inflate(inflater)
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = this@ForgotPasswordFragment.viewModel
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListener()
    }

    private fun setupListener() {
        binding.btnLogin.setOnClickListener {
            if (viewModel.validateEmail()) {
                navigateToLogin()
            } else {
                Toast.makeText(
                    requireContext(),
                    getString(R.string.error_invalid_email),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        binding.btnGotoLogin.setOnClickListener {
            navigateToLogin()
        }
    }

    private fun navigateToLogin() {
        parentFragmentManager.commit {
            replace(R.id.container_view, LoginFragment())
        }
    }
}