package com.ateew.klikego_lite.exception;

import com.ateew.klikego_lite.model.FinalResultId;

public class FinalResultNotFoundException extends RuntimeException {
    public FinalResultNotFoundException(FinalResultId id) {
        super("FinalResult non trouvé avec l'id : " + id);
    }
}