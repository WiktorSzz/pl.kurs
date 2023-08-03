package pl.kurs.exercise5.models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public void addVisit(MedicalVisit visit) {
        visits.add(visit);
    }

    public String getSpecialization() {
        return specialization;
    }

    public String getNipNumber() {
        return nipNumber;
    }

    public String getPesel() {
        return pesel;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public List<MedicalVisit> getVisits() {
        return visits;
    }


    public static List<Doctor> readDoctorFromFile(String filename) {
        List<Doctor> doctors = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\t");
                int id = Integer.parseInt(data[0]);
                String nazwisko = data[1];
                String imie = data[2];
                String specjalnosc = data[3];
                LocalDate dataUrodzenia = LocalDate.parse(data[4]);
                String nip = data[5];
                String pesel = data[6];
                doctors.add(new Doctor(id, nazwisko, imie, specjalnosc, dataUrodzenia, nip, pesel));
            }
        } catch (IOException e) {
            System.out.println("Problem z odczytem pliku: " + filename);
            e.printStackTrace();
        }
        return doctors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return Objects.equals(specialization, doctor.specialization) && Objects.equals(birthDate, doctor.birthDate) && Objects.equals(nipNumber, doctor.nipNumber) && Objects.equals(pesel, doctor.pesel) && Objects.equals(visits, doctor.visits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdNumber(), getName(), getLastname(), getSpecialization(), getBirthDate(), getNipNumber(), getPesel());
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
