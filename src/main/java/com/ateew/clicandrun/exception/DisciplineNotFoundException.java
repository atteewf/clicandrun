package com.ateew.clicandrun.exception;

public  class DisciplineNotFoundException extends RuntimeException {
    public DisciplineNotFoundException(Long id) {
        super("Discipline non trouvé avec l'id : " + id);
    }
}