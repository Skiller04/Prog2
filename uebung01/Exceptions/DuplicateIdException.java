package uebung01.Exceptions;


/**
 * Exception, die ausgelöst wird, wenn versucht wird,
 * eine ID doppelt in das System einzufügen.
 *
 * @author  Justin Preuß, Nemanja Milosevic , Tim Wilde
 * @version  1.0
 */
public class DuplicateIdException extends Exception {

    public DuplicateIdException(String message) {
        super(message);
    }
}
