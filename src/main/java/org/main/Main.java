package org.main;

import java.util.Scanner;
import org.controller.SalaryController;
import org.repository.EmployeeRepository;
import org.repository.EmployeeType;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        EmployeeRepository employeeRepository = new EmployeeRepository();
        employeeRepository.save("FullA", 400, 0, EmployeeType.FullTimeWorker);
        employeeRepository.save("FullB", 300, 0, EmployeeType.FullTimeWorker);
        employeeRepository.save("FullC", 250, 0, EmployeeType.FullTimeWorker);
        employeeRepository.save("PartA", 1, 120, EmployeeType.PartTimeWorker);
        employeeRepository.save("PartB", 2, 60, EmployeeType.PartTimeWorker);
        employeeRepository.save("PartC", 3, 50, EmployeeType.PartTimeWorker);


        System.out.print("이름을 입력하세요: ");
        String name = scanner.next();
        System.out.print("세율을 입력하세요: ");
        double taxRate = scanner.nextDouble();

        SalaryController salaryController = new SalaryController(employeeRepository);
        double salary = salaryController.calculateSalary(name, taxRate);
        System.out.println("salary = " + salary);

        double sumOfPays = salaryController.sumOfPays();
        System.out.println("FullTimeSumOfPays = " + sumOfPays);
    }
}