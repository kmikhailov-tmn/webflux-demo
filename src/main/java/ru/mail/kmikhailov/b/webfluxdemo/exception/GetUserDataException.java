package ru.mail.kmikhailov.b.webfluxdemo.exception;

import java.io.IOException;

public class GetUserDataException extends Throwable {
    public GetUserDataException(IOException throwable) {
        super(throwable);
    }
}
