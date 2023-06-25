package pl.kurs.exercise3.app;

import pl.kurs.exercise3.models.Employee;
import pl.kurs.exercise3.models.Person;
import pl.kurs.exercise3.models.Student;
import pl.kurs.exercise3.services.Sex;

public class SchoolRunner {
    public static void main(String[] args) {

        Student student1 = new Student("Anna", "Kowalska", "92031512345", "Warszawa", "212MCM", 1200);
        Student student2 = new Student("Jan", "Nowak", "95050254331", "Kraków", "202MCM", 800);
        Employee employee1 = new Employee("Marcin", "Wójcik", "80071065432", "Gdańsk", "Dyrektor", 5000);
        Employee employee2 = new Employee("Katarzyna", "Lis", "87052676543", "Wrocław", "Nauczyciel", 3500);
        Person[] people = {student1, student2, employee2, employee1};

        System.out.println(Person.getRichestPerson(people));
        System.out.println(Person.getGender(people, Sex.MALE));
    }


}
