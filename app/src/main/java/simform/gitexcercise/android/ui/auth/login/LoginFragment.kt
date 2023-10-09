package simform.gitexcercise.android.ui.auth.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import simform.gitexcercise.android.R
import simform.gitexcercise.android.databinding.FragmentLoginBinding
import simform.gitexcercise.android.ui.auth.forgotpassword.ForgotPasswordFragment
import simform.gitexcercise.android.ui.auth.register.RegisterFragment
import simform.gitexcercise.android.ui.profile.ProfileActivity

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater)
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = this@LoginFragment.viewModel
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListener()
    }

    private fun setupListener() {
        binding.btnLogin.setOnClickListener {
            if (viewModel.validateLoginDetails()) {
                requireActivity().startActivity(
                    Intent(
                        requireContext(),
                        ProfileActivity::class.java
                    )
                )
                requireActivity().finish()
            } else {
                Toast.makeText(
                    requireContext(),
                    getString(R.string.error_invalid_credentials),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        binding.btnGotoRegistration.setOnClickListener {
            parentFragmentManager.commit {
                replace(R.id.container_view, RegisterFragment())
            }
        }

        binding.btnForgotPassword.setOnClickListener {
            parentFragmentManager.commit {
                replace(R.id.container_view, ForgotPasswordFragment())
            }
        }
    }
}