package pl.kurs.exercise5.models;

import java.time.LocalDate;

public class MedicalVisit {
    private LocalDate date;
    private Doctor doctor;
    private Patient patient;

    public MedicalVisit(LocalDate date, Doctor doctor, Patient patient) {
        this.date = date;
        this.doctor = doctor;
        this.patient = patient;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "MedicalVisit{" + "date=" + date + ", doctor=" + doctor.getLastname() + " " + doctor.getName() + ", patient=" + patient.getLastname() + " " + patient.getName() + '}';
    }
}
