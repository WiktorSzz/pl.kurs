package pl.kurs.exercise5.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Doctor extends Person {
    private String specialization;
    private LocalDate birthDate;
    private String nipNumber;
    private String pesel;
    private List<MedicalVisit> visits;


    public Doctor(int idNumber, String name, String lastname, String specialization, LocalDate birthDate, String nipNumber, String pesel) {
        super(idNumber, name, lastname);
        this.specialization = specialization;
        this.birthDate = birthDate;
        this.nipNumber = nipNumber;
        this.pesel = pesel;
        this.visits = new ArrayList<>();
    }


    public String getSpecialization() {
        return specialization;
    }


    public LocalDate getBirthDate() {
        return birthDate;
    }


    public void setVisits(List<MedicalVisit> visits) {
        this.visits = visits;
    }


    public List<MedicalVisit> getVisits() {
        return visits;
    }

    public List<MedicalVisit> assignVisits(List<MedicalVisit> allVisits) {
        List<MedicalVisit> assignedVisits = new ArrayList<>();
        for (MedicalVisit visit : allVisits) {
            if (visit.getDoctorId() == this.getIdNumber()) {
                assignedVisits.add(visit);
            }
        }
        return assignedVisits;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "idNumber=" + getIdNumber() +
                ", name='" + getName() + '\'' +
                ", lastname='" + getLastname() + '\'' +
                ", specialization='" + specialization + '\'' +
                ", birthDate=" + birthDate +
                ", nipNumber='" + nipNumber + '\'' +
                ", pesel='" + pesel + '\'' +
                ", visits=" + visits +
                '}';
    }
}
