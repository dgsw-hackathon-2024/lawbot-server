package com.lux.lawbot.global.exception.report;


import com.lux.lawbot.global.exception.BusinessException;

public class ReportException extends BusinessException {

    private static final ReportException REPORT_NOT_FOUND_EXCEPTION = new ReportException(ReportError.REPORT_NOT_FOUND_EXCEPTION);

    public ReportException(ReportError error) {
        super(error);
    }

    public static ReportException notFoundReport() {
        return REPORT_NOT_FOUND_EXCEPTION;
    }
}
