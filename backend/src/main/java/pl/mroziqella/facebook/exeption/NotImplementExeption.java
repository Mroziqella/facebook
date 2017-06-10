package pl.mroziqella.facebook.exeption;

/**
 * Created by Mroziqella on 10.06.2017.
 */
public class NotImplementExeption extends RuntimeException {
    public NotImplementExeption() {
    }

    public NotImplementExeption(String message) {
        super(message);
    }

    public NotImplementExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public NotImplementExeption(Throwable cause) {
        super(cause);
    }

    public NotImplementExeption(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
