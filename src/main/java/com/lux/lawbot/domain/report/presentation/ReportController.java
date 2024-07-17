package com.lux.lawbot.domain.report.presentation;

import com.lux.lawbot.domain.report.payload.request.ReportDto;
import com.lux.lawbot.domain.report.service.ReportService;
import com.lux.lawbot.global.common.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "안심신고", description = "안심신고 관련 api 입니다.")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/report")
@RequiredArgsConstructor
public class ReportController {
    private final ReportService reportService;

    @Operation(summary = "신고 리스트", description = "올라온 신고를 확인합니다.")
    @GetMapping("/list")
    public BaseResponse findAllReports(){
        return reportService.findAllReports();
    }

    @Operation(summary = "신고 작성", description = "신고를 작성합니다.")
    @PostMapping("/create")
    public BaseResponse petitionCreate(@RequestBody ReportDto reportDto){
        return reportService.reportCreate(reportDto);
    }

    @Operation(summary = "선택한 청원 단일 조회", description = "선택한 신고의 내용 확인합니다.")
    @GetMapping("/detail/{id}")
    public BaseResponse petitionRead(@PathVariable("id") Long id){
        return reportService.reportRead(id);
    }
}