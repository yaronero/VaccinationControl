package com.example.vaccinationcontrol.ui.main.vaccinations

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.vaccinationcontrol.databinding.FragmentVaccinationsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.SimpleDateFormat
import java.util.Locale

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
        viewModel.vaccinationsFull.observe(viewLifecycleOwner) { vaccinations ->
            val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())

            val sortedVaccination = vaccinations.sortedBy { vaccination ->
                val date = dateFormat.parse(vaccination.vaccinationDate)
                date
            }.reversed()

            adapter.submitList(sortedVaccination)
        }
        viewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            binding.layoutLoading.isVisible = isLoading
            binding.progressBar.isVisible = isLoading
            binding.arrowBack.isEnabled = !isLoading
        }
    }
}