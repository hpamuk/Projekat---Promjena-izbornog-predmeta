package ba.unsa.etf.rpr.exceptions;

public class MyException extends Exception{


    public MyException(String message) {
        super(message);
    }

    public MyException(String message, Exception cause) {
        super(message, cause);
    }
}
