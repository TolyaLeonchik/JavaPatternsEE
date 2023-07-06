package com.patterns.dto;

public class LogicObject {
    Service service = new Service();
    public EmployeeDTO getEmployee() {
        return service.getEmployee();
    }
}
