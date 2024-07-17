package com.lux.lawbot.domain.petition.payload.request;

import java.time.LocalDateTime;

public record PetitionDto(
        Long id,
        String title,
        String contents,
        LocalDateTime createdAt,
        Long likes
) {
}