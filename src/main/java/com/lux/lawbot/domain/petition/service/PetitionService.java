package com.lux.lawbot.domain.petition.service;

import com.lux.lawbot.domain.petition.payload.request.PetitionDto;
import com.lux.lawbot.global.common.BaseResponse;

public interface PetitionService {
    BaseResponse findAllPetitions();
    BaseResponse petitionCreate(PetitionDto petitionDto);
    BaseResponse petitionRead(Long id);
    BaseResponse like(Long id);
    BaseResponse unlike(Long id);
}