package exception;

/**
 * Created by TheDinoSlayer on 11/09/2016.
 */
public class LevelException extends Exception {
    public LevelException() {super();}
    public LevelException(String message) {super(message);}
    public LevelException(String message, Throwable cause) {super(message, cause);}
    public LevelException(Throwable cause) {super(cause);}
}
