package com.ateew.clicandrun.exception;

public class EmailAlreadyExistsException extends RuntimeException {
    public EmailAlreadyExistsException(String email) {
        super("Athlete non trouvé avec l'id : " + email);
    }
}

