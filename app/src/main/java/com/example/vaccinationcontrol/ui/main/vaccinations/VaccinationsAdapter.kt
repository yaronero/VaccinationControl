package com.example.vaccinationcontrol.ui.main.vaccinations

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.vaccinationcontrol.databinding.RvVaccinationItemBinding
import com.example.vaccinationcontrol.domain.models.Vaccination

class VaccinationsAdapter : ListAdapter<Vaccination, VaccinationViewHolder>(VaccinationDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VaccinationViewHolder {
        val binding = RvVaccinationItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return VaccinationViewHolder(parent.context, binding)
    }

    override fun onBindViewHolder(holder: VaccinationViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
}

class VaccinationViewHolder(
    private val context: Context,
    private val binding: RvVaccinationItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(vaccination: Vaccination) {
        binding.vaccinationId.text = vaccination.id.toString()
    }
}

class VaccinationDiffUtil : DiffUtil.ItemCallback<Vaccination>() {

    override fun areItemsTheSame(oldItem: Vaccination, newItem: Vaccination): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Vaccination, newItem: Vaccination): Boolean {
        return oldItem == newItem
    }
}