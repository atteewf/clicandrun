package com.ateew.clicandrun.exception;

import com.ateew.clicandrun.model.FinalResultId;

public class FinalResultNotFoundException extends RuntimeException {
    public FinalResultNotFoundException(FinalResultId id) {
        super("FinalResult non trouvé avec l'id : " + id);
    }
}