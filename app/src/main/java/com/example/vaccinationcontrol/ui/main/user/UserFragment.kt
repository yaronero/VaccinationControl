package com.example.vaccinationcontrol.ui.main.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.vaccinationcontrol.R
import com.example.vaccinationcontrol.databinding.FragmentUserBinding
import com.example.vaccinationcontrol.utils.decodeGender
import com.example.vaccinationcontrol.utils.src
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserFragment : Fragment() {

    private lateinit var binding: FragmentUserBinding

    private val viewModel: UserViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.passportLayout.setOnClickListener {
            viewModel.user.value?.id?.let { id ->
                val toPassportFragment = UserFragmentDirections.toPassportFragment(id)
                findNavController().navigate(toPassportFragment)
            }
        }

        setupObservers()
    }

    private fun setupObservers() {
        viewModel.user.observe(viewLifecycleOwner) { user ->
            if (user.avatar.isNotEmpty()) {
                binding.userAvatar.src(user.avatar)
            }
            binding.name.text =
                requireContext().getString(R.string.full_name, user.firstName, user.lastName)
            binding.email.text = user.email
            binding.username.text = user.username
            binding.gender.text = decodeGender(user.gender, requireContext())
            binding.age.text = user.age.toString()
            binding.phone.text = user.phoneNumber
            binding.address.text = user.address
        }
    }
}