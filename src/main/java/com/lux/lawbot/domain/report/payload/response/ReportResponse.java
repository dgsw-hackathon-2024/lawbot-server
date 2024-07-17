package com.lux.lawbot.domain.report.payload.response;

import lombok.Builder;

@Builder
public record ReportResponse(
        Long id,
        String title,
        String contents
) {
}