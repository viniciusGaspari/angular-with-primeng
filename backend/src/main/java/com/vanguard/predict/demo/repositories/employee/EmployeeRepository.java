package com.vanguard.predict.demo.repositories.employee;

import com.vanguard.predict.demo.models.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Optional<Boolean> existsByEmployeeName(String employeeName);
    Optional<Boolean> existsByEmployeeCpf(Integer employeeCpf);

    Optional<Employee> findByEmployeeCpf(Integer employeeCpf);
}
