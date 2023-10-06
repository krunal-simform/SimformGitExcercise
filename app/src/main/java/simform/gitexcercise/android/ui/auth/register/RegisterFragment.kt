package simform.gitexcercise.android.ui.auth.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import simform.gitexcercise.android.R
import simform.gitexcercise.android.databinding.FragmentRegisterBinding
import simform.gitexcercise.android.ui.auth.login.LoginFragment

class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding
    private val viewModel: RegisterViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterBinding.inflate(inflater)
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = this@RegisterFragment.viewModel
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListener()
    }

    private fun setupListener() {
        binding.btnRegister.setOnClickListener {
            if (viewModel.validateDetails()) {
                // TODO: Navigate to Profile Screen
            } else {
                Toast.makeText(requireContext(), getString(R.string.error_required_fileds), Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnGotoLogin.setOnClickListener {
            parentFragmentManager.commit {
                replace(R.id.container_view, LoginFragment())
            }
        }
    }
}