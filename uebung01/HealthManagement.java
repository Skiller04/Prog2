package uebung01;




import uebung01.Exceptions.DuplicateIdException;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Verwaltet Ärzte und Patienten in einem Health-Management-System.
 *
 * Ermöglicht das Hinzufügen, Suchen und Verwalten von Doctor- und Patient-Objekten.
 *
 * @author Justin Preuß, Nemanja Milosevic, Tim Wilde
 * @version 1.0
 */

public class HealthManagement {
    /**
     * Map, die alle Ärzte speichert, Schlüssel ist die Arzt-ID.
     */
    private Map<Integer, Doctor> doctors = new HashMap<>();
    /**
     * Map, die alle Patienten speichert, Schlüssel ist die Patienten-ID.
     */
    private Map<Integer, Patient> patients = new HashMap<>();

    /**
     * Fügt einen neuen Arzt hinzu.
     *
     * @param doctor Arzt-Objekt, das hinzugefügt werden soll; darf nicht null sein
     * @throws IllegalArgumentException wenn das Arzt-Objekt null ist
     * @throws DuplicateIdException     wenn die ID des Arztes bereits existiert
     */
    public void addDoctor(Doctor doctor) throws DuplicateIdException {
        if ( doctor == null ) {
            throw new IllegalArgumentException ("Arzt darf nicht null sein.");
        }

        if ( doctors.containsKey(doctor.getId()) ) {
            throw new DuplicateIdException("Doctor mit der ID " + doctor.getId() + " existiert bereits.");
        }
        doctors.put(doctor.getId(), doctor);
    }

    /**
     * Fügt einen neuen Patienten hinzu.
     *
     * @param patient Patienten-Objekt, das hinzugefügt werden soll; darf nicht null sein
     * @throws IllegalArgumentException wenn das Patienten-Objekt null ist
     * @throws DuplicateIdException     wenn die ID des Patienten bereits existiert
     */
    public void addPatient(Patient patient) throws DuplicateIdException {
        if (patient == null) {
            throw new IllegalArgumentException("Patienten-Objekt darf nicht null sein.");
        }
        if (patients.containsKey(patient.getId())) {
            throw new DuplicateIdException("Die ID " + patient.getId() + " wird bereits verwendet.");
        }
        patients.put(patient.getId(), patient);
    }

    /**
     * Sucht einen Arzt anhand seiner ID.
     *
     * @param doctorId ID des Arztes
     * @return das Doctor-Objekt mit der angegebenen ID
     * @throws NoSuchElementException wenn kein Arzt mit der ID gefunden wird
     */

    public Doctor findDoctorById(int doctorId) {
        Doctor doctor = doctors.get(doctorId);
        if (doctor == null) {
            throw new NoSuchElementException("Kein Arzt mit der ID " + doctorId + " gefunden.");
        }
        return doctor;
    }


    /**
     * Sucht einen Patienten anhand seiner ID.
     *
     * @param patientId ID des Patienten
     * @return das Patient-Objekt mit der angegebenen ID
     * @throws NoSuchElementException wenn kein Patient mit der ID gefunden wird
     */
    public Patient findPatientById(int patientId) {
        Patient patient = patients.get(patientId);
        if (patient == null) {
            throw new NoSuchElementException("Kein Patient mit der ID " + patientId + " gefunden.");
        }
        return patient;
    }
}

