package com.uninote.exception;

public class NoteNotFound extends UninoteException {

    private static final String MESSAGE = "존재하지 않는 글입니다.";

    public NoteNotFound() {
        super(MESSAGE);
    }

    @Override
    public int getStatusCode() {
        return 404;
    }
}

