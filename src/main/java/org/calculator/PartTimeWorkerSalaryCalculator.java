package org.calculator;

import org.repository.EmployeeRepository;

public class PartTimeWorkerSalaryCalculator implements SalaryCalculator {

    @Override
    public double calculateSalary(String name, double taxRate, EmployeeRepository employeeRepository) {
        int hourlyPay = employeeRepository.findHourlyPay(name);
        int workTime = employeeRepository.findWorkTime(name);
        return (double) hourlyPay * workTime;
    }

    @Override
    public double sumOfPays(EmployeeRepository employeeRepository) {
        return 0;
    }
}
