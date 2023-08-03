package pl.kurs.exercise5.service;

import pl.kurs.exercise5.models.Doctor;
import pl.kurs.exercise5.models.MedicalVisit;
import pl.kurs.exercise5.models.Patient;
import pl.kurs.exercise5.models.Person;

import java.util.*;

public class DataService {


    public static Doctor getDoctorById(int doctorId, List<Doctor> doctors) {
        for (Doctor doctor : doctors) {
            if (doctor.getIdNumber() == doctorId) {
                return doctor;
            }
        }
        throw new NoSuchElementException("Nie znaleziono lekarza o identyfikatorze: " + doctorId);
    }

    public static Patient getPatientById(int patientId, List<Patient> patients) {
        for (Patient patient : patients) {
            if (patient.getIdNumber() == patientId) {
                return patient;
            }
        }
        throw new NoSuchElementException("Nie znaleziono pacjenta o identyfikatorze: " + patientId);
    }

    public static <T extends Person> T findPersonWithMostVisits(List<T> persons, List<MedicalVisit> visits) {
        if (persons.isEmpty() || visits.isEmpty()) {
            return null;
        }

        T personWithMostVisits = persons.get(0);
        int maxVisits = countVisitsForPerson(personWithMostVisits, visits);

        for (T person : persons) {
            int numVisits = countVisitsForPerson(person, visits);
            if (numVisits > maxVisits) {
                maxVisits = numVisits;
                personWithMostVisits = person;
            }
        }

        return personWithMostVisits;
    }

    private static <T extends Person> int countVisitsForPerson(T person, List<MedicalVisit> visits) {
        int count = 0;
        for (MedicalVisit visit : visits) {
            if (visit.getDoctor().equals(person) || visit.getPatient().equals(person)) {
                count++;
            }
        }
        return count;
    }

    public static String findMostPopularSpecialization(List<Doctor> doctors) {
        if (doctors.isEmpty()) {
            return null;
        }
        String mostPopularSpecialization = doctors.get(0).getSpecialization();
        int maxCount = 1;
        for (int i = 0; i < doctors.size(); i++) {
            String currentSpecialization = doctors.get(i).getSpecialization();
            int currentCount = 1;
            for (int j = i + 1; j < doctors.size(); j++) {
                if (doctors.get(j).getSpecialization().equals(currentSpecialization)) {
                    currentCount++;
                }
            }
            if (currentCount > maxCount) {
                maxCount = currentCount;
                mostPopularSpecialization = currentSpecialization;
            }
        }
        return mostPopularSpecialization;
    }

    public static int findYearWithMostVisits(List<MedicalVisit> visits) {
        int[] yearCounts = new int[10000];
        for (MedicalVisit visit : visits) {
            int year = visit.getDate().getYear();
            yearCounts[year]++;
        }
        int maxCount = yearCounts[0];
        int mostVisitedYear = 0;

        for (int i = 1; i < yearCounts.length; i++) {
            if (yearCounts[i] > maxCount) {
                maxCount = yearCounts[i];
                mostVisitedYear = i;
            }
        }
        return mostVisitedYear;
    }

    public static List<String> findTopOldestDoctors(List<Doctor> doctors, int topCount) {
        doctors.sort(Comparator.comparing(Doctor::getBirthDate));
        int count = Math.min(doctors.size(), topCount);
        List<String> oldestDoctors = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Doctor doctor = doctors.get(i);
            oldestDoctors.add("Lekarz " + (i + 1) + ": " + doctor.getName() + " " + doctor.getLastname() + ", Data urodzenia: " + doctor.getBirthDate());
        }

        return oldestDoctors;
    }

    public static List<Patient> findPatientsWithMinimumDifferentDoctors(List<Patient> patients, int minDifferentDoctors) throws IllegalArgumentException {
        List<Patient> result = new ArrayList<>();
        for (Patient patient : patients) {
            Set<Doctor> visitedDoctors = new HashSet<>();
            for (MedicalVisit visit : patient.getVisits()) {
                visitedDoctors.add(visit.getDoctor());
            }
            if (visitedDoctors.size() >= minDifferentDoctors) {
                result.add(patient);
            }
        }
        return result;
    }

    public static List<String> findExclusiveDoctors(List<Doctor> doctors) {
        List<String> exclusiveDoctors = new ArrayList<>();
        for (Doctor doctor : doctors) {
            int uniquePatientsCount = countUniquePatients(doctor, doctors);
            if (uniquePatientsCount == 1) {
                String doctorInfo = doctor.getName() + " " + doctor.getLastname() + ", Data urodzenia: " + doctor.getBirthDate();
                exclusiveDoctors.add(doctorInfo);
            }
        }
        if (exclusiveDoctors.isEmpty()) {
            throw new IllegalArgumentException("Lista ekskluzywnych lekarzy jest pusta!");
        }
        return exclusiveDoctors;
    }

    private static int countUniquePatients(Doctor doctor, List<Doctor> doctors) {
        int uniquePatients = 0;
        for (Doctor d : doctors) {
            if (d != doctor) {
                for (MedicalVisit visit : d.getVisits()) {
                    if (visit.getDoctor().getIdNumber() == doctor.getIdNumber()) {
                        uniquePatients++;
                        break;
                    }
                }
            }
        }
        return uniquePatients;
    }
}

