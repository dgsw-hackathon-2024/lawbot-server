package com.lux.lawbot.domain.petition.service;

import com.lux.lawbot.domain.petition.domain.entity.Petition;
import com.lux.lawbot.domain.petition.domain.repository.PetitionRepository;
import com.lux.lawbot.domain.petition.mapper.PetitionMapper;
import com.lux.lawbot.domain.petition.payload.request.PetitionDto;
import com.lux.lawbot.domain.petition.payload.response.PetitionResponse;
import com.lux.lawbot.global.common.BaseResponse;
import com.lux.lawbot.global.exception.petition.PetitionException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetitionServiceImpl implements PetitionService {

    private final PetitionRepository petitionRepository;
    private final PetitionMapper petitionMapper;

    @Override
    public BaseResponse findAllPetitions() {
        List<Petition> petitions = petitionRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        List<PetitionResponse> dtos = petitionMapper.convertPetitionToDtos(petitions);
        return new BaseResponse(HttpStatus.OK, "모든 청원 불러오기 성공", dtos);
    }

    @Override
    public BaseResponse petitionCreate(PetitionDto petitionDto) {
        petitionRepository.save(petitionMapper.dtoToEntity(petitionDto));
        return new BaseResponse(HttpStatus.OK, "청원 작성 성공");
    }

    @Override
    public BaseResponse petitionRead(Long id) {
        Petition petition = petitionRepository.findById(id).orElseThrow(PetitionException::notFoundPetition);
        return new BaseResponse(HttpStatus.OK, "청원 단일 조회 성공", petitionMapper.entityToDto(petition));
    }
}