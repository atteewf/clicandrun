package com.ateew.clicandrun.exception;

public  class NationalityNotFoundException extends RuntimeException {
    public NationalityNotFoundException(Long id) {
        super("Nationalité non trouvée avec l'id : " + id);
    }
}