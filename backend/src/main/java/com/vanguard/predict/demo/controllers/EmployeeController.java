package com.vanguard.predict.demo.controllers;

import com.vanguard.predict.demo.models.employee.EmployeeRegisterRequest;
import com.vanguard.predict.demo.services.employee.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth/employee")
public class EmployeeController {

    privare final EmployeeService employeeService;

    @PostMapping("/employee-register")
    public ResponseEntity<?> register(@RequestBody EmployeeRegisterRequest request){

    }

}
