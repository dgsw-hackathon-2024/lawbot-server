package com.lux.lawbot.global.exception.petition;


import com.lux.lawbot.global.exception.BusinessException;

public class PetitionException extends BusinessException {

    private static final PetitionException PETITION_NOT_FOUND_EXCEPTION = new PetitionException(PetitionError.PETITION_NOT_FOUND_EXCEPTION);

    public PetitionException(PetitionError error) {
        super(error);
    }

    public static PetitionException notFoundPetition() {
        return PETITION_NOT_FOUND_EXCEPTION;
    }
}
