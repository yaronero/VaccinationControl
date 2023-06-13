package com.example.vaccinationcontrol.ui.main.vaccinations

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.vaccinationcontrol.R
import com.example.vaccinationcontrol.databinding.RvVaccinationItemBinding
import com.example.vaccinationcontrol.domain.models.VaccinationFullInfo
import java.text.SimpleDateFormat
import java.util.Locale

class VaccinationsAdapter : ListAdapter<VaccinationFullInfo, VaccinationViewHolder>(VaccinationDiffUtil()) {

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

    fun bind(vaccination: VaccinationFullInfo) {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val date = dateFormat.parse(vaccination.vaccinationDate)
        val dateFormatted = date?.let { dateFormat.format(it) }
        binding.note.text = vaccination.notes
        binding.vaccineName.text = vaccination.vaccine.name
        binding.doctorName.text = context.getString(R.string.full_name, vaccination.employee.firstName, vaccination.employee.lastName)
        binding.location.text = vaccination.vaccinationLocation
        binding.date.text = dateFormatted
    }
}

class VaccinationDiffUtil : DiffUtil.ItemCallback<VaccinationFullInfo>() {

    override fun areItemsTheSame(oldItem: VaccinationFullInfo, newItem: VaccinationFullInfo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: VaccinationFullInfo, newItem: VaccinationFullInfo): Boolean {
        return oldItem == newItem
    }
}