package ru.mail.kmikhailov.b.webfluxdemo.exception;

public class CriticalUserDataError extends RuntimeException {
    public CriticalUserDataError(Throwable throwable) {
        super(throwable);
    }
}
