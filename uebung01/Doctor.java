package uebung01;

import uebung01.Exceptions.InvalidNameException;

/**
 * Beschreibt einen Arzt mit Name und ID.
 *
 * @author Justin Preuß, Nemnaja Milosevic, Tim Wilde
 * @version 1.0
 */

public class Doctor {
    /**
     * Name des Arztes.
     */
    private final String name;
    /**
     * Eindeutige ID des Arztes.
     */
    private final int id;
    /**
     * Erstellt einen neuen Arzt.
     *
     * @param name Name des Arztes; darf nicht leer oder null sein
     * @param id   Eindeutige ID des Arztes
     * @throws InvalidNameException falls der Name leer oder nur aus Leerzeichen besteht
     */
    public Doctor(String name,  int id) throws InvalidNameException {
        if (name == null || name.trim().equals("")) {
            throw new InvalidNameException("Ungültiger Name: Name darf nicht leer oder nur aus Leerzeichen bestehen.");
        }
        this.name = name;
        this.id = id;
    }
    /**
     * Gibt den Namen des Arztes zurück.
     *
     * @return Name des Arztes
     */
    public String getName() {
        return name;
    }
    /**
     * Gibt die ID des Arztes zurück.
     *
     * @return ID des Arztes
     */
    public int getId() {
        return id;
    }
    /**
     * Gibt den Arzt als Text zurück.
     * Format: Doctor{id=ID, name='NAME'}
     *
     * @return Arzt als String
     */
    public String toString() {
        return "Doctor{id=" + id + ", name='" + name + "'}";
    }

}

