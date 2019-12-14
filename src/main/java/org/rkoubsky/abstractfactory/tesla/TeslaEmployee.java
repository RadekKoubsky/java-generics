package org.rkoubsky.abstractfactory.tesla;

import org.rkoubsky.abstractfactory.api.Employee;

public class TeslaEmployee implements Employee {
    private final String name;

    public TeslaEmployee(final String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
