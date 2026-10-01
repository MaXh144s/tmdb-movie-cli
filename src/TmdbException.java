package src;

public class TmdbException extends RuntimeException {

    public TmdbException(String msg) {
        super(msg);
    }

    public TmdbException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
