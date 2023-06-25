package pl.kurs.exercise3.models;

public class Employee extends Person {
    private String workplace;
    private double salary;

    public Employee(String firstName, String secondName, String pesel, String city, String workplace, double salary) {
        super(firstName, secondName, pesel, city);
        this.workplace = workplace;
        this.salary = salary;
    }

    @Override
    public double getIncome() {
        return salary;
    }

    @Override
    public String toString() {
        return super.toString() + ", stanowisko= " + workplace + ", pensja= " + salary + "}";
    }
}
