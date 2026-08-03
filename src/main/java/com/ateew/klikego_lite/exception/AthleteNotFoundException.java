package com.ateew.klikego_lite.exception;

public  class AthleteNotFoundException extends RuntimeException {
    public AthleteNotFoundException(Long id) {
        super("Athlete non trouvé avec l'id : " + id);
    }
}