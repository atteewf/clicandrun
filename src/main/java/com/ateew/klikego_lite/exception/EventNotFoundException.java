package com.ateew.klikego_lite.exception;

public  class EventNotFoundException extends RuntimeException {
    public EventNotFoundException(Long id) {
        super("Event non trouvé avec l'id : " + id);
    }
}