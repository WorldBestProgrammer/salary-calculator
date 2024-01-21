package org.repository;

import java.util.HashMap;

public class EmployeeRepository {
    private final HashMap<String, Integer> pays;
    private final HashMap<String, Integer> times;
    private final HashMap<String, EmployeeType> employeeTypes;

    public EmployeeRepository() {
        pays = new HashMap<>();
        times = new HashMap<>();
        employeeTypes = new HashMap<>();
    }

    public void save(String name, int pay, int time, EmployeeType employeeType) {
        pays.put(name, pay);
        times.put(name, time);
        employeeTypes.put(name, employeeType);
    }

    public HashMap<String, Integer> findAllPays() {
        return pays;
    }

    public HashMap<String, EmployeeType> findAllEmployeeTypes() {
        return employeeTypes;
    }

    public int findBasePay(String name) {
        return pays.get(name);
    }

    public int findHourlyPay(String name) {
        return pays.get(name);
    }

    public int findWorkTime(String name) {
        return times.get(name);
    }

    public EmployeeType findEmployeeType(String name) {
        return employeeTypes.get(name);
    }
}
