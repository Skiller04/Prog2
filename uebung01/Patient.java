package uebung01;

import uebung01.Exceptions.InvalidNameException;

import java.util.Objects;
/**
 * Diese Klasse beschreibt einen Patienten mit einem eindeutigen Namen und einer ID.
 * Ein {@code Patient}-Objekt speichert grundlegende Informationen über eine Person
 * im System, wie den Namen und eine eindeutige Identifikationsnummer.
 * Der Name darf nicht null, leer oder nur aus Leerzeichen bestehen.
 * Zwei Patienten gelten als gleich, wenn sie die gleiche ID besitzen.
 *
 * @author Justin Preuß, Nemanja Milosevic, Tim Wilde
 * @version 1.0
 */

public class Patient {
    /**
     * Der Name des Patienten.
     */
    private final String name;
    /**
     * Die eindeutige ID des Patienten.
     */
    private final int id;
    /**
     * Konstruktor, der ein neues {@code Patient}-Objekt erstellt.
     *
     * @param name der Name des Patienten; darf nicht null oder leer sein
     * @param id   die eindeutige Identifikationsnummer des Patienten
     * @throws InvalidNameException wenn der Name null, leer oder nur aus Leerzeichen besteht
     */

    public Patient(String name, int id) throws InvalidNameException {
        if (name == null || name.trim().equals("")) {
            throw new InvalidNameException("Ungültiger Name: Name darf nicht leer oder nur aus Leerzeichen bestehen.");
        }
        this.name = name;
        this.id = id;
    }
    /**
     * Gibt den Namen des Patienten zurück.
     *
     * @return der Name des Patienten
     */

    public String getName() {
        return name;
    }
    /**
     * Gibt die eindeutige ID des Patienten zurück.
     *
     * @return die Patienten-ID
     */

    public int getId() {
        return id;
    }
    /**
     * Gibt den Patienten als Text zurück.
     * Format: Patient{id=ID, name='NAME'}
     *
     * @return Patient als String
     */
    @Override
    public String toString() {
        return "Patient{id=" + id + ", name='" + name + "'}";
    }

    /**
     * Vergleicht dieses {@code Patient}-Objekt mit einem anderen Objekt.
     * Zwei Patienten gelten als gleich, wenn sie dieselbe ID haben.
     *
     * @param obj das zu vergleichende Objekt
     * @return {@code true}, wenn beide Patienten die gleiche ID besitzen,
     *         andernfalls {@code false}
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true; // gleiche Referenz
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false; // anderes Objekt oder null
        }
        Patient other = (Patient) obj;
        return this.id == other.id; // Gleichheit nur anhand der ID
    }
    /**
     * Gibt den Hashcode dieses Patientenobjekts zurück.
     * Der Hashcode basiert ausschließlich auf der Patienten-ID.
     *
     * @return der Hashcode des Patienten
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}



