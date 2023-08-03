package pl.kurs.exercise5.models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static pl.kurs.exercise5.service.DataService.getDoctorById;
import static pl.kurs.exercise5.service.DataService.getPatientById;

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


    public Doctor getDoctor() {
        return doctor;
    }


    public Patient getPatient() {
        return patient;
    }


    public static List<MedicalVisit> odczytajWizyty(String filename, List<Doctor> doctors, List<Patient> patients) {
        List<MedicalVisit> visits = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            br.readLine();
            String line;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\t");
                int idLekarza = Integer.parseInt(data[0]);
                int idPacjenta = Integer.parseInt(data[1]);
                LocalDate dataWizyty = LocalDate.parse(data[2], formatter);

                Doctor doctor = getDoctorById(idLekarza, doctors);
                Patient patient = getPatientById(idPacjenta, patients);

                if (doctor != null && patient != null) {
                    MedicalVisit visit = new MedicalVisit(dataWizyty, doctor, patient);
                    visits.add(visit);

                    patient.addVisit(visit);

                    doctor.addVisit(visit);
                }
            }
        } catch (IOException e) {
            System.out.println("Problem z odczytem pliku: " + filename);
            e.printStackTrace();
        }
        return visits;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicalVisit that = (MedicalVisit) o;
        return Objects.equals(date, that.date) &&
                doctor.getIdNumber() == that.doctor.getIdNumber() &&
                patient.getIdNumber() == that.patient.getIdNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDate(), getDoctor(), getPatient());
    }

    @Override
    public String toString() {
        return "MedicalVisit{" + "date=" + date + ", doctor=" + doctor.getLastname() + " " + doctor.getName() + ", patient=" + patient.getLastname() + " " + patient.getName() + '}';
    }
}

