package uebung01;

import uebung01.Exceptions.DuplicateIdException;
import uebung01.Exceptions.InvalidNameException;

/**
 * Testet das HealthManagement-System.
 *
 * Dieses Programm führt verschiedene Tests durch, um die Funktionalität
 * von Ärzten, Patienten und dem HealthManagement zu prüfen.
 * Es werden sowohl gültige als auch fehlerhafte Eingaben getestet,
 * z.B.:
 * - Arzt/Patient mit ungültigem Namen
 * - Arzt/Patient mit doppelter ID
 * - Null-Objekte
 * - Suche nach nicht vorhandenen IDs
 *
 * Für jeden Testfall wird das Ergebnis in der Konsole ausgegeben.
 * Exceptions werden abgefangen und als Fehlermeldung angezeigt.
 *
 * @author Justin Preuß, Nemanja Milosevic, Tim Wilde
 * @version  1.0
 */

public class Main {
    /**
     * Startet das Testprogramm für HealthManagement.
     * Führt verschiedene Tests für Ärzte und Patienten durch
     * und gibt die Ergebnisse auf der Konsole aus.
     *
     * @param args Kommandozeilenargumente (nicht verwendet)
     */
    public static void main(String[] args) {
        HealthManagement hm = new HealthManagement();

        // TEST 1: Ungültiger Name bei Arzt
        System.out.println("=== TEST 1: Ungültiger Name bei Arzt ===");
        try {
            Doctor d1 = new Doctor("   ", 1); // nur Leerzeichen -> ungültig
            hm.addDoctor(d1);
        } catch (DuplicateIdException | InvalidNameException e) {
            System.out.println("Fehler: " + e.getMessage());
        }

        // TEST 2: Gültiger Arzt hinzufügen
        System.out.println("\n=== TEST 2: Gültiger Arzt hinzufügen ===");
        try {
            Doctor d2 = new Doctor("Dr. Müller", 2);
            hm.addDoctor(d2);
            System.out.println("Erfolgreich hinzugefügt: " + d2);
        } catch (DuplicateIdException | InvalidNameException e) {
            System.out.println("Fehler: " + e.getMessage());
        }

        // TEST 3: Null als Arzt hinzufügen
        System.out.println("\n=== TEST 3: Null als Arzt hinzufügen ===");
        try {
            hm.addDoctor(null);
        } catch (IllegalArgumentException | DuplicateIdException e) {
            System.out.println("Fehler: " + e.getMessage());
        }

        // TEST 4: Doppelte ID beim Arzt
        System.out.println("\n=== TEST 4: Doppelte ID beim Arzt ===");
        try {
            Doctor d3 = new Doctor("Dr. Schulz", 2); // gleiche ID wie d2
            hm.addDoctor(d3);
        } catch (DuplicateIdException | InvalidNameException e) {
            System.out.println("Fehler: " + e.getMessage());
        }

        // TEST 5: Nicht vorhandenen Arzt finden
        System.out.println("\n=== TEST 5: Nicht vorhandenen Arzt finden ===");
        try {
            Doctor notFound = hm.findDoctorById(99);
            System.out.println("Gefunden: " + notFound);
        } catch (Exception e) {
            System.out.println("Fehler: " + e.getMessage());
        }

        // TEST 6: Patienten hinzufügen
        System.out.println("\n=== TEST 6: Patienten hinzufügen ===");
        try {
            Patient p1 = new Patient("Lisa Sommer", 1);
            hm.addPatient(p1);
            System.out.println("Patient hinzugefügt: " + p1);

            Patient p2 = new Patient("Anna Weber", 1); // gleiche ID
            hm.addPatient(p2);
        } catch (DuplicateIdException | InvalidNameException e) {
            System.out.println("Fehler: " + e.getMessage());
        }

        // TEST 7: Null als Patient hinzufügen
        System.out.println("\n=== TEST 7: Null als Patient ===");
        try {
            hm.addPatient(null);
        } catch (IllegalArgumentException | DuplicateIdException e) {
            System.out.println("Fehler: " + e.getMessage());
        }

        // TEST 8: Patient mit ungültigem Namen
        System.out.println("\n=== TEST 8: Patient mit ungültigem Namen ===");
        try {
            Patient p3 = new Patient("   ", 0); // leerer Name
            hm.addPatient(p3);
        } catch (DuplicateIdException | InvalidNameException e) {
            System.out.println("Fehler: " + e.getMessage());
        }

        // TEST 9: Nicht vorhandenen Patienten finden
        System.out.println("\n=== TEST 9: Nicht vorhandenen Patienten finden ===");
        try {
            Patient notFound = hm.findPatientById(999);
            System.out.println("Gefunden: " + notFound);
        } catch (Exception e) {
            System.out.println("Fehler: " + e.getMessage());
        }

        System.out.println("\n=== ALLE TESTS BEENDET ===");
    }
}

