package com.lux.lawbot.domain.petition.payload.response;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record PetitionResponse(
        Long id,
        String title,
        String contents,
        LocalDateTime createdAt,
        Long likes
) {
}