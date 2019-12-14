package org.rkoubsky.abstractfactory.ford;

import org.rkoubsky.abstractfactory.api.Employee;

public class FordEmployee implements Employee {
    private final String name;

    public FordEmployee(final String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
