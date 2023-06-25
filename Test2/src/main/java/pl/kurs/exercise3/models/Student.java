package pl.kurs.exercise3.models;

public class Student extends Person {
    private String group;
    private double scholarship;

    public Student(String firstName, String secondName, String pesel, String city, String group, double scholarship) {
        super(firstName, secondName, pesel, city);
        this.group = group;
        this.scholarship = scholarship;
    }

    @Override
    public double getIncome() {
        return scholarship;
    }

    @Override
    public String toString() {
        return super.toString() + ", grupa= " + group + ", pensja= " + scholarship + "}";
    }
}
