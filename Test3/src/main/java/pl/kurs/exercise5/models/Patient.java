package pl.kurs.exercise5.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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


    public List<MedicalVisit> getVisits() {
        return visits;
    }

    public void setVisits(List<MedicalVisit> visits) {
        this.visits = visits;
    }

    public List<MedicalVisit> assignVisits(List<MedicalVisit> allVisits) {
        visits = new ArrayList<>();
        for (MedicalVisit visit : allVisits) {
            if (visit.getPatientId() == this.getIdNumber()) {
                visits.add(visit);
            }
        }
        return allVisits;
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