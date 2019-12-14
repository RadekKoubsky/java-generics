package org.rkoubsky.abstractfactory;

import org.rkoubsky.abstractfactory.api.Employee;
import org.rkoubsky.abstractfactory.ford.FordEmployee;
import org.rkoubsky.abstractfactory.tesla.TeslaEmployee;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ClassManager<T extends Employee> {

    public Set<Class<T>> getEmployeeClasses()  {
        final Set<Class<T>> registrations = new HashSet<>();
        /**
         * Using T type parameter, we are guaranteed that we can
         * add only those classes to the Set<T> that extends Employee
         *
         * e.g. registrations.add((Class<T>) String.class); // does not compile
         */
        registrations.add((Class<T>) TeslaEmployee.class);
        registrations.add((Class<T>) FordEmployee.class);

        return Collections.unmodifiableSet(registrations);
    }

    public static void main(final String[] args) {
        deviceRegistrations();
    }

    public static Set<Class<?>> deviceRegistrations() {
        final ClassManager<? extends Employee> manager = new ClassManager<>();
        final Set<?> employeeClasses = manager.getEmployeeClasses();
        System.out.println(employeeClasses);

        final Set<Class<?>> classes = new HashSet<>();
        classes.add(TeslaEmployee.class);
        classes.add(String.class);
        System.out.println(classes);
        return classes;
    }
}
