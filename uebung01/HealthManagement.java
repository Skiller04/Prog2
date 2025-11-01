package uebung01;




import uebung01.Exceptions.DuplicateIdException;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class HealthManagement {
    private Map<Integer, Doctor> doctors = new HashMap<>();
    private Map<Integer, Patient> patients = new HashMap<>();

    public void addDoctor(Doctor doctor) throws DuplicateIdException {
        if ( doctor == null ) {
            throw new IllegalArgumentException ("Doctor cannot be null");
        }
        
        if ( doctors.containsKey(doctor.getId()) ) {
            throw new DuplicateIdException("Doctor with id " + doctor.getId + " already exists");
        }
        doctors.put(doctor.getId(), doctor);
    }

    public void addPatient(Patient patient) throws DuplicateIdException {
        if (patient == null) {
            throw new IllegalArgumentException("Patienten-Objekt darf nicht null sein.");
        }
        if (patients.containsKey(patient.getId())) {
            throw new DuplicateIdException("Die ID " + patient.getId() + " wird bereits verwendet.");
        }
        patients.put(patient.getId(), patient);
    }

    public Doctor findDoctorById(int doctorId) {
        Doctor doctor = doctors.get(doctorId);
        if (doctor == null) {
            throw new NoSuchElementException("Kein Arzt mit der ID " + doctorId + " gefunden.");
        }
        return doctor;
    }

    public Patient findPatientById(int patientId) {
        Patient patient = patients.get(patientId);
        if (patient == null) {
            throw new NoSuchElementException("Kein Patient mit der ID " + patientId + " gefunden.");
        }
        return patient;
    }
}

