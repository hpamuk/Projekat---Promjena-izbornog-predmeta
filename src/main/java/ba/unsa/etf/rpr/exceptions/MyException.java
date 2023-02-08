package ba.unsa.etf.rpr.exceptions;

/**
 * My exception
 * @author Hena Pamuk
 */
public class MyException extends Exception{

    /**
     * Instantiates a new My exception.
     *
     * @param message the message
     */
    public MyException(String message) {
        super(message);
    }

    /**
     * Instantiates a new My exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public MyException(String message, Exception cause) {
        super(message, cause);
    }
}
