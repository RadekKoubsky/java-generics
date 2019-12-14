package org.rkoubsky.abstractfactory.tesla;

import org.rkoubsky.abstractfactory.api.AssemblyLine;
import org.rkoubsky.abstractfactory.api.CompanyFactory;

public class TeslaFactory implements CompanyFactory<TeslaEmployee> {
    @Override
    public TeslaEmployee makeEmployee(final String name) {
        return new TeslaEmployee(name);
    }

    @Override
    public AssemblyLine<TeslaEmployee> makeAssemblyLine() {
        return new TeslaAssemblyLine();
    }
}
