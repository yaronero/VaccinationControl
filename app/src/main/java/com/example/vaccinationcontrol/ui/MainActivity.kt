package com.example.vaccinationcontrol.ui

import android.os.Bundle
import com.example.vaccinationcontrol.databinding.ActivityMainBinding
import com.zeugmasolutions.localehelper.LocaleAwareCompatActivity

class MainActivity : LocaleAwareCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
