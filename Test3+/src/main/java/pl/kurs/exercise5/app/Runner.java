package pl.kurs.exercise5.app;

import pl.kurs.exercise5.models.Doctor;
import pl.kurs.exercise5.models.MedicalVisit;
import pl.kurs.exercise5.models.Patient;
import pl.kurs.exercise5.service.DataService;

import java.util.List;


public class Runner {
    public static void main(String[] args) {
        List<Patient> patients = Patient.readPatientFromFile("pacjenci.txt");
        List<Doctor> doctors = Doctor.readDoctorFromFile("lekarze.txt");
        List<MedicalVisit> allVisits = MedicalVisit.odczytajWizyty("wizyty.txt", doctors, patients);

        System.out.println("Patients: " + patients);
        System.out.println("Doctors: " + doctors);
        System.out.println("MedicalVisit: " + allVisits);
        System.out.println("/////////////////////////////////////////////////////");

        System.out.println(DataService.findPersonWithMostVisits(doctors, allVisits));
        System.out.println(DataService.findPersonWithMostVisits(patients, allVisits));
        System.out.println(DataService.findMostPopularSpecialization(doctors));
        System.out.println(DataService.findYearWithMostVisits(allVisits));
        System.out.println(DataService.findTopOldestDoctors(doctors, 5));
        System.out.println(DataService.findPatientsWithMinimumDifferentDoctors(patients, 5));
        System.out.println(DataService.findExclusiveDoctors(doctors));
    }
}




