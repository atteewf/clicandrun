package com.ateew.klikego_lite.exception;

public  class NationalityNotFoundException extends RuntimeException {
    public NationalityNotFoundException(Long id) {
        super("Nationalité non trouvée avec l'id : " + id);
    }
}