package com.vanguard.predict.demo.services.employee;

import com.vanguard.predict.demo.helpers.BcryptHelper;
import com.vanguard.predict.demo.helpers.employee.EmployeeHelper;
import com.vanguard.predict.demo.models.employee.Employee;
import com.vanguard.predict.demo.validator.BcryptValidator;
import com.vanguard.predict.demo.validator.employee.EmployeeValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EmployeeService {

    private final EmployeeHelper employeeHelper;
    private final BcryptHelper bcryptHelper;

    private final EmployeeValidator employeeValidator;
    private final BcryptValidator bcryptValidator;

    public Employee register(Employee request){
        this.employeeValidator.existsEmployeeByName(request.getEmployeeName());
        this.employeeValidator.existsEmployeeByCpf(request.getEmployeeCpf());

        request.setEmployeePassword(this.bcryptHelper.encodeNewPassword(request.getEmployeePassword()));

        return this.employeeHelper.saveEmployee(request);
    }

    public Employee login(Employee request){
        Employee employeeFound = this.employeeHelper.getEmployeeByCpf(request.getEmployeeCpf());
        this.bcryptValidator.isPasswordMatches(
                request.getEmployeePassword(),
                employeeFound.getEmployeePassword()
        );
        return employeeFound;
    }

}
