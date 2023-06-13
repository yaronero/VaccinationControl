package com.example.vaccinationcontrol.ui.main.vaccinations

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.vaccinationcontrol.databinding.FragmentVaccinationsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class VaccinationFragment : Fragment() {

    private lateinit var binding: FragmentVaccinationsBinding

    private val viewModel: VaccinationViewModel by viewModel()

    private val args: VaccinationFragmentArgs by navArgs()

    private val adapter by lazy {
        VaccinationsAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentVaccinationsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvVaccinations.adapter = adapter

        binding.arrowBack.setOnClickListener {
            findNavController().navigateUp()
        }

        viewModel.getVaccinationsByUserId(args.userId)
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.vaccinations.observe(viewLifecycleOwner) { vaccinations ->
            adapter.submitList(vaccinations)
        }
    }
}