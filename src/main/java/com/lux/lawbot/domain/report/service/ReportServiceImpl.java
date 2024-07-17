package com.lux.lawbot.domain.report.service;

import com.lux.lawbot.domain.report.domain.entity.Report;
import com.lux.lawbot.domain.report.domain.repository.ReportRepository;
import com.lux.lawbot.domain.report.mapper.ReportMapper;
import com.lux.lawbot.domain.report.payload.request.ReportDto;
import com.lux.lawbot.domain.report.payload.response.ReportResponse;
import com.lux.lawbot.global.common.BaseResponse;
import com.lux.lawbot.global.exception.report.ReportException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final ReportRepository reportRepository;
    private final ReportMapper reportMapper;

    @Override
    public BaseResponse findAllReports() {
        List<Report> reports = reportRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        List<ReportResponse> dtos = reportMapper.convertPetitionToDtos(reports);
        return new BaseResponse(HttpStatus.OK, "모든 신고 불러오기 성공", dtos);
    }

    @Override
    public BaseResponse reportCreate(ReportDto reportDto) {
        reportRepository.save(reportMapper.dtoToEntity(reportDto));
        return new BaseResponse(HttpStatus.OK, "신고 작성 성공");
    }

    @Override
    public BaseResponse reportRead(Long id) {
        Report report = reportRepository.findById(id).orElseThrow(ReportException::notFoundReport);
        return new BaseResponse(HttpStatus.OK, "신고 단일 조회 성공", reportMapper.entityToDto(report));
    }
}