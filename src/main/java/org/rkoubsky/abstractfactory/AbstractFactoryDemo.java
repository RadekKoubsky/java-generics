package org.rkoubsky.abstractfactory;

import org.reflections.Reflections;
import org.rkoubsky.abstractfactory.api.AssemblyLine;
import org.rkoubsky.abstractfactory.api.CompanyFactory;
import org.rkoubsky.abstractfactory.api.Employee;

public class AbstractFactoryDemo {

    public static void main(final String[] args) {
        /**
         * We cannot add employee to assembly line as we don't know the type and could potentially
         * violate type safety, thus compiler does not allow addEmployee operation.
         *
         * AssemblyLine<? extends Employee> = factory.makeAssemblyLine();
         * Employee employee = companyFactory.makeEmployee("John");
         * teslaAssemblyLine.addEmployee(employee.getName(), employee);  // does not compile
         *
         * Solution1 - make employee and add employee actions are executed in one generic method
         *
         * Solution2 - make employee and add employee actions are executed in one class bounded with type
         * parameter, see EmployeeManager class
         *
         */

        final Reflections reflections = new Reflections("org.rkoubsky");
        reflections.getSubTypesOf(CompanyFactory.class).stream().forEach(impl -> {
            try {
                printEmployees(impl.getDeclaredConstructor().newInstance());
            } catch (final Throwable e) {
                e.printStackTrace();
            }
        });


    }

    private static void printEmployees(final CompanyFactory<? extends Employee> companyFactory) {
        final EmployeeManager<? extends Employee> manager = new EmployeeManager<>(companyFactory);
        manager.addEmployee("John");
        manager.addEmployee("Kevin");
        manager.addEmployee("Susan");
        System.out.printf("EmployeeManager with assembly line and its employees of the same type:\n%s \n", manager);
    }

    /**
     * Solution1 - make employee and add employee actions are executed in one generic method
     *
     * Create a generic method with type parameter that bounds the assembly line and employee, thus
     * it is type safe
     */
    private static <T extends Employee> AssemblyLine<T> addEmployeeGenericMethodTypeParam(final CompanyFactory<T> factory){
        final AssemblyLine<T> assemblyLine = factory.makeAssemblyLine();
        final T employee = factory.makeEmployee("John");
        assemblyLine.addEmployee(employee.getName(), employee);
        return assemblyLine;
    }
}
