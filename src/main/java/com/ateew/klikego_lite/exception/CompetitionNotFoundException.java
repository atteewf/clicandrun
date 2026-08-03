package com.ateew.klikego_lite.exception;

public  class CompetitionNotFoundException extends RuntimeException {
    public CompetitionNotFoundException(Long id) {
        super("Competition non trouvé avec l'id : " + id);
    }
}