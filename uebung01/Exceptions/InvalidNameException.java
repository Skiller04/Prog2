package uebung01.Exceptions;

/**
 * Exception, die ausgelöst wird, wenn ein ungültiger Name
 * für einen Arzt oder Patienten verwendet wird.
 *
 * Ein Name gilt als ungültig, wenn er null, leer oder nur aus
 * Leerzeichen besteht.
 *
 * @author Justin Preuß, Nemanja Milosevic, Tim Wilde
 * @version 1.0
 */
public class InvalidNameException extends RuntimeException {

    /**
     * Erstellt eine neue InvalidNameException mit einer Fehlermeldung.
     *
     * @param message die Fehlermeldung, die beschreibt, warum der Name ungültig ist
     */
    public InvalidNameException(String message) {
        super(message);
    }
}
