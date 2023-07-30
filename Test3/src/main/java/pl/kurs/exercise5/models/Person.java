package pl.kurs.exercise5.models;

public abstract class Person {
    private int idNumber;
    private String name;
    private String lastname;

    public Person(int idNumber, String name, String lastname) {
        this.idNumber = idNumber;
        this.name = name;
        this.lastname = lastname;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    @Override
    public String toString() {
        return "Person{" +
                "idNumber=" + getIdNumber() +
                ", name='" + getName() + '\'' +
                ", lastname='" + getLastname() + '\'' +
                '}';
    }
}
