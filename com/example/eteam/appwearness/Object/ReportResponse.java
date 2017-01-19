package com.example.eteam.appwearness.Object;

import java.util.List;

public class ReportResponse {
    private List<ReportType> reportTypes;
    private List<Report> reports;

    public ReportResponse(List<ReportType> reportTypes, List<Report> reports) {
        this.reportTypes = reportTypes;
        this.reports = reports;
    }

    public List<ReportType> getReportTypes() {
        return this.reportTypes;
    }

    public void setReportTypes(List<ReportType> reportTypes) {
        this.reportTypes = reportTypes;
    }

    public List<Report> getReports() {
        return this.reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }
}
