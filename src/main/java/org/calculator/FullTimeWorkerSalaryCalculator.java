package org.calculator;

import java.util.HashMap;
import org.repository.EmployeeRepository;
import org.repository.EmployeeType;

public class FullTimeWorkerSalaryCalculator implements SalaryCalculator {

    @Override
    public double calculateSalary(String name, double taxRate, EmployeeRepository employeeRepository) {
        int basePay = employeeRepository.findBasePay(name);
        return basePay * (1 - taxRate);
    }

    @Override
    public double sumOfPays(EmployeeRepository employeeRepository) {
        HashMap<String, Integer> allPays = employeeRepository.findAllPays();
        HashMap<String, EmployeeType> allEmployeeTypes = employeeRepository.findAllEmployeeTypes();

        int sumOfPays = 0;
        for (String name : allEmployeeTypes.keySet()) {
            if (allEmployeeTypes.get(name) == EmployeeType.FullTimeWorker) {
                sumOfPays += allPays.get(name);
            }
        }
        return sumOfPays;
    }
}
