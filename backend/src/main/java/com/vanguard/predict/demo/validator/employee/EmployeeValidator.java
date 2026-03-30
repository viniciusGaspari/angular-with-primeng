package com.vanguard.predict.demo.validator.employee;

import com.vanguard.predict.demo.exceptions.MyRuntimeException;
import com.vanguard.predict.demo.repositories.employee.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class EmployeeValidator {

    private final EmployeeRepository employeeRepository;

    public void existsEmployeeByName(String employeeName){
        this.employeeRepository.existsByEmployeeName(employeeName)
                .orElseThrow(() -> new MyRuntimeException("Já existe nome de funcionário cadastrado", 422));
    }

    public void existsEmployeeByCpf(Integer employeeCpf) {
        this.employeeRepository.existsByEmployeeCpf(employeeCpf)
                .orElseThrow(() -> new MyRuntimeException("Já existe cpf de funcionário cadastrado", 422));
    }
}
