package simform.gitexcercise.android.ui.profile.viewprofile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import simform.gitexcercise.android.R
import simform.gitexcercise.android.databinding.FragmentViewProfileBinding
import simform.gitexcercise.android.ui.profile.ProfileViewModel

class ViewProfileFragment : Fragment(), MenuProvider {

    private lateinit var binding: FragmentViewProfileBinding
    private val viewModel: ProfileViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentViewProfileBinding.inflate(inflater)
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = this@ViewProfileFragment.viewModel
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.CREATED)
    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.fragment_view_profile, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        // TODO: Navigate to Edit Profile screen 
        return true
    }
}