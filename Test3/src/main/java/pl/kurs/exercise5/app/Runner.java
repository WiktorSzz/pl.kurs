package pl.kurs.exercise5.app;

import pl.kurs.exercise5.models.Doctor;
import pl.kurs.exercise5.models.MedicalVisit;
import pl.kurs.exercise5.models.Patient;
import pl.kurs.exercise5.service.DataService;

import java.util.List;

import static pl.kurs.exercise5.service.DataService.findExclusiveDoctors;

public class Runner {
    public static void main(String[] args) {
        List<Patient> patients = DataService.createFromFile("pacjenci.txt", Patient.class);
        List<Doctor> doctors = DataService.createFromFile("lekarze.txt", Doctor.class);
        List<MedicalVisit> allVisits = DataService.createFromFile("wizyty.txt", MedicalVisit.class);

        // Przypisanie wizyt do pacjentów
        for (Patient patient : patients) {
            List<MedicalVisit> assignedVisits = patient.assignVisits(allVisits);
            patient.setVisits(assignedVisits);
        }

        // Przypisanie wizyt do lekarzy
        for (Doctor doctor : doctors) {
            List<MedicalVisit> assignedVisits = doctor.assignVisits(allVisits);
            doctor.setVisits(assignedVisits);
        }
        System.out.println("Patients: " + patients);
        System.out.println("Doctors: " + doctors);

        System.out.println(DataService.findDoctorWithMostVisits(doctors));
        System.out.println(DataService.findPatientWithMostVisits(patients));
        System.out.println(DataService.findMostPopularSpecialization(doctors));
        System.out.println(DataService.findYearWithMostVisits(allVisits));
        System.out.println(DataService.findTopOldestDoctors(doctors, 5));
        System.out.println(DataService.findPatientsWithMinimumDifferentDoctors(patients, 5));
        System.out.println(findExclusiveDoctors(doctors));


    }
}



