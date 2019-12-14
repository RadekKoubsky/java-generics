package org.rkoubsky.wildcards;

import java.util.ArrayList;
import java.util.List;

public class WildcardsDemo {
    public static void main(final String[] args) {
        final List<Object> objects = list(new Employee());
        final List<Person> persons = list(new Employee());
        final List<Student> students = list(new Student());

        // we can pass any type to the unbounded wildcard list
        printUnboundedWildcard(objects);
        printUnboundedWildcard(persons);
        printUnboundedWildcard(students);


        // we can't pass List<Object> as Object does not extend Person
        // printPeopleUpperBoundedWildcard(objects);
        printUpperBoundedWildcard(persons);
        printUpperBoundedWildcard(students);

        // we can pass List<Object> as Object is a supertype of Student
        printPeopleLowerBoundedWildcard(objects);
        printPeopleLowerBoundedWildcard(persons);
        printPeopleLowerBoundedWildcard(students);
    }

    /**
     * List<?> is an unbounded wildcard, an element of the List can be of any type e.g. Object
     */
    public static void printUnboundedWildcard(final List<?> people) {
        // an element must be the Object type as we do not have any lower/upper bound on the parameter list
        final Object person = people.get(0);
        System.out.println(person);

        /**
         * We can't add an element to the unbounded wildcard parameter as
         * we do not know what is the type of elements in the list
         *
         * people.add(new Student()); compilation error
         */
    }

    /**
     * List<? extends Person> is an upper bounded wildcard, an element in the List is a subtype
     * of the Person class
     *
     * We can only read data from the generic list as we use 'extends' upper bounded wildcard
     *
     * This is the Producer part of the Producer Extends Consumer Super pattern.
     *
     */
    public static void printUpperBoundedWildcard(final List<? extends Person> people) {
        /**
         * The list acts as Producer to the Person variable, the java compiler guarantees that
         * the list can contain any subtype of Person.
         *
         * We can get items from the list, but cannot insert them.
         */
        final Person person = people.get(0);
        System.out.println(person);

        /**
         * We can't add Student or Employee to the upper bounded wildcard parameter as
         * we do not know what is the type of elements in the list, it can be Student, Employee etc.
         * Thus, the compiler does not allow to insert any type of items to preserve type safety.
         *
         * people.add(new Student()); compilation error
         */
    }

    /**
     * List<? super Student> is a lower bounded wildcard, an element in the List is a super type
     * of the Student class
     *
     * We can add data to the generic list as we use 'super' lower bounded wildcard
     *
     * We can read elements from the list, but we don't know the type of the supertypes
     * of Student, thus we have to cast the elements to Object.
     *
     * This is the Consumer part of the Producer Extends Consumer Super pattern.
     */
    public static void printPeopleLowerBoundedWildcard(final List<? super Student> people) {

        /**
         * The list can contain any super types of Student, but the compiler does not
         * know which ones, thus we have to return Object instead to preserve type safety.
         * In this case, the list consumes the type of the element.
         */
        final Object person = people.get(0);
        System.out.println(person);

        /**
         * We can insert any subtype into the list bounded with supertype,
         * thus we can add Student class or any subtype of it to the list.
         */
        people.add(new Student());

        /**
         * But we can't add any supertype of Student
         *
         * people.add(new Object()); compilation error
         */
    }

    private static <T> List<T> list(final T person) {
        final List<T> people = new ArrayList<>();
        people.add(person);
        return people;
    }
}
