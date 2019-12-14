package org.rkoubsky.abstractfactory.tesla;

import org.rkoubsky.abstractfactory.api.AssemblyLine;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class TeslaAssemblyLine implements AssemblyLine<TeslaEmployee> {
    private final Map<String, TeslaEmployee> employees = new HashMap<>();

    @Override
    public TeslaEmployee getEmployeeByName(final String name) {
        return this.employees.get(name);
    }

    @Override
    public void addEmployee(final String name, final TeslaEmployee employee) {
        this.employees.put(name, employee);
    }

    @Override
    public String toString() {
        return "TeslaAssemblyLine{" +
                "employees=[" + this.printTypes() +
                "]}";
    }

    private String printTypes() {
        return this.employees.entrySet().stream().map(employee -> {
            return String.format("%s=%s", employee.getKey(), employee.getValue().getClass());
        }).collect(Collectors.joining(","));
    }
}
