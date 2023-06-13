package com.example.vaccinationcontrol.ui.main.passport

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.vaccinationcontrol.databinding.FragmentPassportBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.text.SimpleDateFormat
import java.util.Locale

class PassportFragment : Fragment() {

    private lateinit var binding: FragmentPassportBinding

    private val viewModel: PassportViewModel by viewModel()

    private val args: PassportFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPassportBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.arrowBack.setOnClickListener {
            findNavController().navigateUp()
        }

        viewModel.getPassportByUserId(args.userId)
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.passport.observe(viewLifecycleOwner) { passport ->
            val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val date = dateFormat.parse(passport.expirationDate)
            val dateFormatted = date?.let { dateFormat.format(it) }
            binding.number.text = passport.passportNumber
            binding.note.text = passport.notes
            binding.country.text = passport.country
            binding.expirationDate.text = dateFormatted

        }
    }
}