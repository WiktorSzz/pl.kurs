package pl.kurs.exercise5.service;

import pl.kurs.exercise5.models.Doctor;
import pl.kurs.exercise5.models.MedicalVisit;
import pl.kurs.exercise5.models.Patient;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DataService {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-M-dd");






























    public static <T> List<T> createFromFile(String fileName, Class<T> dataType) {
        List<T> dataList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\t");
                int id = Integer.parseInt(data[0]);
                String lastName = data[1];
                String name = data[2];

                if (dataType == Doctor.class) {
                    String specialization = data[3];
                    LocalDate birthDate = parseDate(data[4]);
                    String nip = data[5];
                    String pesel = data[6];
                    dataList.add(dataType.getConstructor(int.class, String.class, String.class, String.class, LocalDate.class, String.class, String.class).newInstance(id, lastName, name, specialization, birthDate, nip, pesel));

                } else if (dataType == Patient.class) {
                    String pesel = data[3];
                    LocalDate birthDatePatient = parseDate(data[4]);
                    dataList.add(dataType.getConstructor(int.class, String.class, String.class, String.class, LocalDate.class).newInstance(id, lastName, name, pesel, birthDatePatient));
                } else if (dataType == MedicalVisit.class) {
                    int doctorId = Integer.parseInt(data[0]);
                    int patientId = Integer.parseInt(data[1]);
                    LocalDate visitDate = parseDate(data[2]);
                    dataList.add(dataType.getConstructor(int.class, int.class, LocalDate.class).newInstance(doctorId, patientId, visitDate));
                }
            }
        } catch (IOException e) {
            System.out.println("Problem z odczytem pliku: " + fileName);
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Błąd podczas tworzenia obiektu: " + e.getMessage());
            e.printStackTrace();
        }
        return dataList;
    }

    private static LocalDate parseDate(String date) {
        try {
            return LocalDate.parse(date, DATE_FORMATTER);
        } catch (java.time.format.DateTimeParseException e) {
            return LocalDate.parse(date.replaceFirst("(?<!\\d)\\d(?![\\d-])", "0$0"), DATE_FORMATTER);
        }
    }

    public static Doctor findDoctorWithMostVisits(List<Doctor> doctors) {
        if (doctors.isEmpty()) {
            return null;
        }
        Doctor doctorWithMostVisits = doctors.get(0);
        int maxVisits = doctorWithMostVisits.getVisits().size();
        for (Doctor doctor : doctors) {
            int numVisits = doctor.getVisits().size();
            if (numVisits > maxVisits) {
                maxVisits = numVisits;
                doctorWithMostVisits = doctor;
            }
        }
        return doctorWithMostVisits;
    }

    public static Patient findPatientWithMostVisits(List<Patient> patients) {
        if (patients.isEmpty()) {
            return null;
        }
        Patient patientWithMostVisits = patients.get(0);
        int maxVisits = patientWithMostVisits.getVisits().size();

        for (Patient patient : patients) {
            int numVisits = patient.getVisits().size();
            if (numVisits > maxVisits) {
                maxVisits = numVisits;
                patientWithMostVisits = patient;
            }
        }
        return patientWithMostVisits;
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
            int year = visit.getVisitDate().getYear();
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

    public static List<Patient> findPatientsWithMinimumDifferentDoctors(List<Patient> patients, int minDifferentDoctors) {
        List<Patient> result = new ArrayList<>();
        for (Patient patient : patients) {
            int differentDoctors = 0;
            List<Integer> visitedDoctors = new ArrayList<>();
            for (MedicalVisit visit : patient.getVisits()) {
                int doctorId = visit.getDoctorId();
                if (!visitedDoctors.contains(doctorId)) {
                    visitedDoctors.add(doctorId);
                    differentDoctors++;
                }
            }
            if (differentDoctors >= minDifferentDoctors) {
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
                    if (visit.getDoctorId() == doctor.getIdNumber()) {
                        uniquePatients++;
                        break;
                    }
                }
            }
        }
        return uniquePatients;
    }
}

