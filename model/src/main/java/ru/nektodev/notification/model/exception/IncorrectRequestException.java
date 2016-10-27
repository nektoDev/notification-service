package ru.nektodev.notification.model.exception;

/**
 * @author nektodev
 * @date 27/10/2016
 */
public class IncorrectRequestException extends RuntimeException {
    public IncorrectRequestException(String message) {
        super(message);
    }

    public IncorrectRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectRequestException(Throwable cause) {
        super(cause);
    }

    protected IncorrectRequestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
