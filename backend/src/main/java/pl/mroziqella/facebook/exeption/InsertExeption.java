package pl.mroziqella.facebook.exeption;

/**
 * Created by Mroziqella on 08.06.2017.
 */
public class InsertExeption extends RuntimeException {
    public InsertExeption() {
    }

    public InsertExeption(String message) {
        super(message);
    }

    public InsertExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public InsertExeption(Throwable cause) {
        super(cause);
    }

    public InsertExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}