package com.ateew.clicandrun.exception;

public  class EventNotFoundException extends RuntimeException {
    public EventNotFoundException(Long id) {
        super("Event non trouvé avec l'id : " + id);
    }
}