package org.rkoubsky.abstractfactory.api;

public interface CompanyFactory<T extends Employee> {

    T makeEmployee(String name);

    AssemblyLine<T> makeAssemblyLine();
}
