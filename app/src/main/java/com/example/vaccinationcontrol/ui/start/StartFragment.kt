package com.example.vaccinationcontrol.ui.start

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.vaccinationcontrol.R
import com.example.vaccinationcontrol.databinding.FragmentStartBinding
import com.example.vaccinationcontrol.utils.getCurrentLocale
import com.zeugmasolutions.localehelper.LocaleAwareCompatActivity
import com.zeugmasolutions.localehelper.Locales
import java.util.Locale

class StartFragment : Fragment() {

    private lateinit var binding: FragmentStartBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val locale = getCurrentLocale(requireContext())
        updateChangeLocaleButton(locale)

        binding.btnLogin.setOnClickListener {
            val toLoginFragment = StartFragmentDirections.toLoginFragment()
            findNavController().navigate(toLoginFragment)
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
    }

    private fun updateChangeLocaleButton(locale: Locale) {
        if(locale == Locales.Ukrainian) {
            binding.ivLocaleFlag.setImageResource(R.drawable.ic_britain_flag)
        } else {
            binding.ivLocaleFlag.setImageResource(R.drawable.ic_ukraine_flag)
        }
    }
}