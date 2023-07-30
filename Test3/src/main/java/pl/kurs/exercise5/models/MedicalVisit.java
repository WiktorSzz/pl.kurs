package pl.kurs.exercise5.models;

import java.time.LocalDate;

public class MedicalVisit {
    private int doctorId;
    private int patientId;
    private LocalDate visitDate;

    public MedicalVisit(int doctorNumberId, int patientNumberId, LocalDate visitDate) {
        this.doctorId = doctorNumberId;
        this.patientId = patientNumberId;
        this.visitDate = visitDate;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public int getPatientId() {
        return patientId;
    }

    public LocalDate getVisitDate() {
        return visitDate;
    }

    @Override
    public String toString() {
        return "MedicalVisit{" +
                "doctorNumberId=" + doctorId +
                ", patientNumberId=" + patientId +
                ", visitDate=" + visitDate +
                '}';
    }
}
