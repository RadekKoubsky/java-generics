package org.rkoubsky.abstractfactory;

import org.rkoubsky.abstractfactory.api.AssemblyLine;
import org.rkoubsky.abstractfactory.api.CompanyFactory;
import org.rkoubsky.abstractfactory.api.Employee;

/**
 * Solution2 - make employee and add employee actions are executed in one class bounded with type Sparameter
 * @param <T> an employee type to be used to add employees to the assembly line
 */
public class EmployeeManager<T extends Employee> {
    private final CompanyFactory<T> factory;
    private final AssemblyLine<T> assemblyLine;


    public EmployeeManager(final CompanyFactory<T> factory) {
        this.factory = factory;
        this.assemblyLine = factory.makeAssemblyLine();
    }

    public T getEmployee(final String name){
        return this.assemblyLine.getEmployeeByName(name);
    }

    public void addEmployee(final String name){
        final T employee = this.factory.makeEmployee(name);
        this.assemblyLine.addEmployee(employee.getName(), employee);
    }

    @Override
    public String toString() {
        return "EmployeeManager{" +
                "factory=" + this.factory +
                ", assemblyLine=" + this.assemblyLine +
                '}';
    }
}
