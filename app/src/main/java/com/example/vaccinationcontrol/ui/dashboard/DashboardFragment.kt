package com.example.vaccinationcontrol.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.vaccinationcontrol.databinding.FragmentDashboardBinding
import com.example.vaccinationcontrol.utils.TokenState
import org.koin.androidx.viewmodel.ext.android.viewModel

class DashboardFragment : Fragment() {

    private lateinit var binding: FragmentDashboardBinding

    private val viewModel: DashboardViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupObservers()
    }

    private fun setupObservers() {
        viewModel.tokenState.observe(viewLifecycleOwner) { tokenState ->
            when(tokenState) {
                TokenState.ExpiredJWT -> {
                    val toStartFragment = DashboardFragmentDirections.toStartFragment()
                    findNavController().navigate(toStartFragment)
                }
                TokenState.WorkingJWT -> {
                    val toUserFragment = DashboardFragmentDirections.toUserFragment()
                    findNavController().navigate(toUserFragment)
                }
            }
        }
    }
}