package uebung01;

import uebung01.Exceptions.DuplicateIdException;
import uebung01.Exceptions.InvalidNameException;



public class Main {
    public static void main(String[] args) {
        HealthManagement hm = new HealthManagement();

        System.out.println("=== TEST 1: Ungültiger Name bei Arzt ===");
        try {
            Doctor d1 = new Doctor("   ", 1); // nur Leerzeichen -> ungültig
            hm.addDoctor(d1);
        } catch (DuplicateIdException | InvalidNameException e) {
            System.out.println("Fehler: " + e.getMessage());
        }

        System.out.println("\n=== TEST 2: Gültiger Arzt hinzufügen ===");
        try {
            Doctor d2 = new Doctor("Dr. Müller", 2);
            hm.addDoctor(d2);
            System.out.println("Erfolgreich hinzugefügt: " + d2);
        } catch (DuplicateIdException | InvalidNameException e) {
            System.out.println("Fehler: " + e.getMessage());
        }

        System.out.println("\n=== TEST 3: Null als Arzt hinzufügen ===");
        try {
            hm.addDoctor(null);
        } catch (IllegalArgumentException | DuplicateIdException e) {
            System.out.println("Fehler: " + e.getMessage());
        }

        System.out.println("\n=== TEST 4: Doppelte ID beim Arzt ===");
        try {
            Doctor d3 = new Doctor("Dr. Schulz", 2); // gleiche ID wie d2
            hm.addDoctor(d3);
        } catch (DuplicateIdException | InvalidNameException e) {
            System.out.println("Fehler: " + e.getMessage());
        }
        System.out.println("\n=== TEST 5: Nicht vorhandenen Arzt finden ===");
        try {
            Doctor notFound = hm.findDoctorById(99);
            System.out.println("Gefunden: " + notFound);
        } catch (Exception e) {
            System.out.println("Fehler: " + e.getMessage());
        }

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

        System.out.println("\n=== TEST 7: Null als Patient ===");
        try {
            hm.addPatient(null);
        } catch (IllegalArgumentException | DuplicateIdException e) {
            System.out.println("Fehler: " + e.getMessage());
        }

        System.out.println("\n=== TEST 8: Patient mit ungültigem Namen ===");
        try {
            Patient p3 = new Patient("   ", 0); // leerer Name
            hm.addPatient(p3);
        } catch (DuplicateIdException | InvalidNameException e) {
            System.out.println("Fehler: " + e.getMessage());
        }

        System.out.println("\n=== TEST 9: Nicht vorhandenen Patienten finden ===");
        try {
            Patient notFound = hm.findPatientById(999);
            System.out.println("Gefunden: " + notFound);
        } catch (Exception e) {
            System.out.println("Fehler: " + e.getMessage());
        }

        System.out.println("\n=== ALLE TESTS BEENDET ===");

    }
     /*
     * Reflektion:
     * Checked Exceptions finde ich sinnvoll, wenn man mit Fehlern rechnen muss, die man vorhersehen kann,
     * z. B. wenn man prüft, ob ein Element schon in einer Liste ist und sonst ein Duplikat entsteht.
     * Unchecked Exceptions benutze ich eher bei Programmierfehlern, wie z. B. wenn man zu weit auf ein Array zugreift.
     * Wenn man defensiv programmiert, also Eingaben vorher prüft und Exceptions abfängt,
     * kann man verhindern, dass das Programm einfach abstürzt, und es stabiler machen.
     */
}

