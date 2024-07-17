package com.lux.lawbot.global.exception.petition;

import com.lux.lawbot.global.exception.error.ErrorProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum PetitionError implements ErrorProperty {
    PETITION_NOT_FOUND_EXCEPTION(HttpStatus.NOT_FOUND, "해당 청원을 찾을 수 없습니다.");

    private final HttpStatus status;
    private final String message;
}
