package org.rkoubsky.abstractfactory.api;

public interface AssemblyLine<T extends Employee> {

    T getEmployeeByName(String name);

    void addEmployee(String name, T employee);
}
