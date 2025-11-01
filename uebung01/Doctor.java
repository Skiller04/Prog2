package uebung01;

import uebung01.Exceptions.InvalidNameException;

public class Doctor {
    private String name;
    private int id;
    public Doctor(String name,  int id) throws InvalidNameException {
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
    public String toString() {
        return "Doctor{id=" + id + ", name='" + name + "'}";
    }

}

