package pl.kurs.exercise5.models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Patient extends Person {
    private String pesel;
    private LocalDate birthDate;

    private List<MedicalVisit> visits;

    public Patient(int idNumber, String name, String lastname, String pesel, LocalDate birthDate) {
        super(idNumber, name, lastname);
        this.pesel = pesel;
        this.birthDate = birthDate;
        this.visits = new ArrayList<>();
    }


    public void addVisit(MedicalVisit visit) {
        visits.add(visit);
    }

    public List<MedicalVisit> getVisits() {
        return visits;
    }


    public static List<Patient> readPatientFromFile(String filename) {
        List<Patient> patients = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\t");
                int id = Integer.parseInt(data[0]);
                String nazwisko = data[1];
                String imie = data[2];
                String pesel = data[3];
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");
                LocalDate dataUrodzenia = LocalDate.parse(data[4], formatter);

                patients.add(new Patient(id, nazwisko, imie, pesel, dataUrodzenia));
            }
        } catch (IOException e) {
            System.out.println("Problem z odczytem pliku" + filename);
            e.printStackTrace();
        }
        return patients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(pesel, patient.pesel) && Objects.equals(birthDate, patient.birthDate) && Objects.equals(visits, patient.visits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pesel, birthDate, visits);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "idNumber=" + getIdNumber() +
                ", name='" + getName() + '\'' +
                ", lastname='" + getLastname() + '\'' +
                ", pesel=" + pesel +
                ", birthDate=" + birthDate +
                '}';
    }
}


