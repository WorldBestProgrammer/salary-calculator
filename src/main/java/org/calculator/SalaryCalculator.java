package org.calculator;

import org.repository.EmployeeRepository;

public interface SalaryCalculator {
    double calculateSalary(String name, double taxRate, EmployeeRepository employeeRepository);
    double sumOfPays(EmployeeRepository employeeRepository);

}
