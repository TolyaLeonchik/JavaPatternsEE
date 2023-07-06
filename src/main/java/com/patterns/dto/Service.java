package com.patterns.dto;

public class Service {
    public EmployeeDTO getEmployee() {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setName("Nikita");
        employeeDTO.setSalary(1240);
        return employeeDTO;
    }
}
