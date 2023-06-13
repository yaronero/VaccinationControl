package com.example.vaccinationcontrol.ui.auth.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.vaccinationcontrol.R
import com.example.vaccinationcontrol.databinding.FragmentLoginBinding
import com.example.vaccinationcontrol.utils.getCurrentLocale
import com.zeugmasolutions.localehelper.LocaleAwareCompatActivity
import com.zeugmasolutions.localehelper.Locales
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.Locale

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    private val viewModel: LoginViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val locale = getCurrentLocale(requireContext())
        updateChangeLocaleButton(locale)

        binding.btnLogin.setOnClickListener {
            viewModel.login(binding.etEmail.text.toString(), binding.etPassword.text.toString())
        }

        binding.arrowBack.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.cardChangeLocale.setOnClickListener {
            val curLocale = getCurrentLocale(requireContext())
            if(curLocale == Locales.Ukrainian) {
                (requireActivity() as LocaleAwareCompatActivity).updateLocale(Locales.English)
                updateChangeLocaleButton(Locales.English)
            } else {
                (requireActivity() as LocaleAwareCompatActivity).updateLocale(Locales.Ukrainian)
                updateChangeLocaleButton(Locales.Ukrainian)
            }
        }

        setupObservers()
    }

    private fun setupObservers() {
        viewModel.token.observe(viewLifecycleOwner) {
            val toUserFragment = LoginFragmentDirections.toUserFragment()
            findNavController().navigate(toUserFragment)
        }
        viewModel.error.observe(viewLifecycleOwner) {
            Toast.makeText(
                requireContext(),
                requireContext().getString(R.string.login_error),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun updateChangeLocaleButton(locale: Locale) {
        if(locale == Locales.Ukrainian) {
            binding.ivLocaleFlag.setImageResource(R.drawable.ic_britain_flag)
        } else {
            binding.ivLocaleFlag.setImageResource(R.drawable.ic_ukraine_flag)
        }
    }
}