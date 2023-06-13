package com.example.vaccinationcontrol.data.mappers

import com.example.vaccinationcontrol.data.api.models.employee.EmployeeItem
import com.example.vaccinationcontrol.domain.models.Employee

class EmployeeMapper {

    fun mapEmployeeItemToEmployeeModel(employeeItem: EmployeeItem): Employee {
        return Employee(
            id = employeeItem.id,
            firstName = employeeItem.first_name,
            lastName = employeeItem.last_name,
            address = employeeItem.address,
            age = employeeItem.age,
            avatar = employeeItem.avatar,
            contactNumber = employeeItem.contact_number,
            email = employeeItem.email,
            gender = employeeItem.gender,
            licenseNumber = employeeItem.license_number,
            phoneNumber = employeeItem.phone_number,
            specialization = employeeItem.specialization
        )
    }
}