package com.ateew.clicandrun.exception;

public  class CompetitionNotFoundException extends RuntimeException {
    public CompetitionNotFoundException(Long id) {
        super("Competition non trouvé avec l'id : " + id);
    }
}