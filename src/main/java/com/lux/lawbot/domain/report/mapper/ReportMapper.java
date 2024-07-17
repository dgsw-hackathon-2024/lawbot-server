package com.lux.lawbot.domain.report.mapper;

import com.lux.lawbot.domain.report.domain.entity.Report;
import com.lux.lawbot.domain.report.payload.request.ReportDto;
import com.lux.lawbot.domain.report.payload.response.ReportResponse;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReportMapper {
    public ReportResponse entityToDto(Report entity) {
        return ReportResponse.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .contents(entity.getContents())
                .build();
    }

    public Report dtoToEntity(ReportDto dto) {
        return Report.builder()
                .title(dto.title())
                .contents(dto.contents())
                .build();
    }

    public List<ReportResponse> convertPetitionToDtos(List<Report> reports) {
        return reports.stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }
}