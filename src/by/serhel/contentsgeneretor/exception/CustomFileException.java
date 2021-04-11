package by.serhel.contentsgeneretor.exception;

public class CustomFileException extends Exception{
    public CustomFileException() {
    }

    public CustomFileException(String message) {
        super(message);
    }

    public CustomFileException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomFileException(Throwable cause) {
        super(cause);
    }
}
