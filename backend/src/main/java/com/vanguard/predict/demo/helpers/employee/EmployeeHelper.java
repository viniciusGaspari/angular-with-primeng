package com.vanguard.predict.demo.helpers.employee;

import com.vanguard.predict.demo.exceptions.MyRuntimeException;
import com.vanguard.predict.demo.models.employee.Employee;
import com.vanguard.predict.demo.repositories.employee.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployeeHelper {

    private final EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee request){
        this.employeeRepository.save(request);
    }

    public Employee getEmployeeByCpf(Integer employeeCpf) {
        return this.employeeRepository.findByEmployeeCpf(employeeCpf)
                .orElseThrow(() -> new MyRuntimeException("Não existe CPF cadastrado", 404));
    }
}
