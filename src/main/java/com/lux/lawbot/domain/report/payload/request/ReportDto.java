package com.lux.lawbot.domain.report.payload.request;

public record ReportDto(
        Long id,
        String title,
        String contents
) {
}