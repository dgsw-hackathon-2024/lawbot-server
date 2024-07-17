package com.lux.lawbot.global.exception.report;

import com.lux.lawbot.global.exception.error.ErrorProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ReportError implements ErrorProperty {
    REPORT_NOT_FOUND_EXCEPTION(HttpStatus.NOT_FOUND, "해당 신고를 찾을 수 없습니다.");

    private final HttpStatus status;
    private final String message;
}
