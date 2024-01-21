package org.controller;

import org.calculator.FullTimeWorkerSalaryCalculator;
import org.calculator.PartTimeWorkerSalaryCalculator;
import org.calculator.SalaryCalculator;
import org.repository.EmployeeRepository;
import org.repository.EmployeeType;

public class SalaryController {
    EmployeeRepository employeeRepository;
    SalaryCalculator salaryCalculator;

    public SalaryController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public double calculateSalary(String name, double taxRate) {
        if (employeeRepository.findEmployeeType(name) == EmployeeType.FullTimeWorker){
            salaryCalculator = new FullTimeWorkerSalaryCalculator();
            return salaryCalculator.calculateSalary(name, taxRate, employeeRepository);
        }
        if (employeeRepository.findEmployeeType(name) == EmployeeType.PartTimeWorker) {
            salaryCalculator = new PartTimeWorkerSalaryCalculator();
            return salaryCalculator.calculateSalary(name, taxRate, employeeRepository);
        }
            return -1;
    }

    public double sumOfPays() {
        salaryCalculator = new FullTimeWorkerSalaryCalculator();
        return salaryCalculator.sumOfPays(employeeRepository);
    }
}
