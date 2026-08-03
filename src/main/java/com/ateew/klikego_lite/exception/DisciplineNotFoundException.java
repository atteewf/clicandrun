package com.ateew.klikego_lite.exception;

public  class DisciplineNotFoundException extends RuntimeException {
    public DisciplineNotFoundException(Long id) {
        super("Discipline non trouvé avec l'id : " + id);
    }
}