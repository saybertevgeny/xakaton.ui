package com.example.application.services;

import com.example.application.data.dto.EmployeeDto;

public interface EmpoyeeService {

    /**
     * Вернет сотрудника по классификации и приоритезации
     * @param classification
     * @param priority
     * @return
     */
    public EmployeeDto findEmployee(String classification, String priority);
}
