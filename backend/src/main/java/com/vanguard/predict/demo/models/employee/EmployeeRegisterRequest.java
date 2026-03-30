package com.vanguard.predict.demo.models.employee;

public record EmployeeRegisterRequest(
        String employeeName,
        String employeePassword,
        Integer companyId
) {
}
