package org.rkoubsky.abstractfactory.ford;

import org.rkoubsky.abstractfactory.api.AssemblyLine;
import org.rkoubsky.abstractfactory.api.CompanyFactory;

public class FordFactory implements CompanyFactory<FordEmployee> {
    @Override
    public FordEmployee makeEmployee(final String name) {
        return new FordEmployee(name);
    }

    @Override
    public AssemblyLine<FordEmployee> makeAssemblyLine() {
        return new FordAssemblyLine();
    }
}
