package pl.kurs.exercise3.models;

import pl.kurs.exercise3.services.Sex;

public abstract class Person {
    private String firstName;
    private String secondName;
    private String pesel;
    private String city;


    public Person(String firstName, String secondName, String pesel, String city) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.pesel = pesel;
        this.city = city;
    }

    public static int getGender(Person[] people, Sex sex) {
        int peopleCounter = 0;

        for (Person person : people) {
            if (person != null) {
                int number = Character.getNumericValue(person.pesel.charAt(9));
                Sex personSex = (number % 2 == 0) ? Sex.FEMALE : Sex.MALE;

                if (personSex == sex) {
                    peopleCounter++;
                }
            }
        }

        return peopleCounter;
    }

    public static Person getRichestPerson(Person... people) {
        Person richestPerson = people[0];
        for (int i = 0; i < people.length; i++) {
            if (people[i] != null) {
                if (people[i].getIncome() > richestPerson.getIncome()) {
                    richestPerson = people[i];
                }
            }
        }
        return richestPerson;
    }


    public abstract double getIncome();

    @Override
    public String toString() {
        return "Person{" + "firstName='" + firstName + '\'' + ", secondName='" + secondName + '\'' + ", pesel='" + pesel + '\'' + ", city='" + city + '\'';
    }
}
