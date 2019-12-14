package org.rkoubsky.abstractfactory.ford;

import org.rkoubsky.abstractfactory.api.AssemblyLine;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FordAssemblyLine implements AssemblyLine<FordEmployee> {
    private final Map<String, FordEmployee> employees = new HashMap<>();

    @Override
    public FordEmployee getEmployeeByName(final String name) {
        return this.employees.get(name);
    }

    @Override
    public void addEmployee(final String name, final FordEmployee employee) {
        this.employees.put(name, employee);
    }

    @Override
    public String toString() {
        return "FordAssemblyLine{" +
                "employees=[" + this.printTypes() +
                "]}";
    }

    private String printTypes() {
        return this.employees.entrySet().stream().map(employee -> {
            return String.format("%s=%s", employee.getKey(), employee.getValue().getClass());
        }).collect(Collectors.joining(","));
    }
}
