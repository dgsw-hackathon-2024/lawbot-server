package com.lux.lawbot.domain.report.service;

import com.lux.lawbot.domain.report.payload.request.ReportDto;
import com.lux.lawbot.global.common.BaseResponse;

public interface ReportService {
    BaseResponse findAllReports();
    BaseResponse reportCreate(ReportDto reportDto);
    BaseResponse reportRead(Long id);
}