package com.lux.lawbot.domain.petition.mapper;

import com.lux.lawbot.domain.petition.domain.entity.Petition;
import com.lux.lawbot.domain.petition.payload.request.PetitionDto;
import com.lux.lawbot.domain.petition.payload.response.PetitionResponse;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PetitionMapper {
    public PetitionResponse entityToDto(Petition entity) {
        return PetitionResponse.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .contents(entity.getContents())
                .createdAt(LocalDateTime.now())
                .likes(entity.getLikes())
                .build();
    }

    public Petition dtoToEntity(PetitionDto dto) {
        return Petition.builder()
                .title(dto.title())
                .contents(dto.contents())
                .createdAt(LocalDateTime.now())
                .likes(0L)
                .build();
    }

    public List<PetitionResponse> convertPetitionToDtos(List<Petition> petitions) {
        return petitions.stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }
}