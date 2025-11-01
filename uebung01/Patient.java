package uebung01;

import uebung01.Exceptions.InvalidNameException;

import java.util.Objects;

public class Patient {
    private String name;
    private int id;

    public Patient(String name, int id) throws InvalidNameException {
        if (name == null || name.trim().equals("")) {
            throw new InvalidNameException("Ungültiger Name: Name darf nicht leer oder nur aus Leerzeichen bestehen.");
        }
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
    @Override
    public String toString() {
        return "Patient{id=" + id + ", name='" + name + "'}";
    }

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

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}



