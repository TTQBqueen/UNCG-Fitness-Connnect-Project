package com.UNCG_Fitness.UNCG_Fitness_Connect.report;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class ReportService {

    @Autowired
    private com.UNCG_Fitness.UNCG_Fitness_Connect.report.reportRepository reportRepository;

    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    public Report getReportById(int reportId) {
        return com.UNCG_Fitness.UNCG_Fitness_Connect.report.reportRepository.findById(reportId).orElse(null);
    }

    public List<Report> getReportByType(String reportType) {
        return com.UNCG_Fitness.UNCG_Fitness_Connect.report.reportRepository.findByReportType(reportType);
    }

    public Report addNewReport(Report report) {
        report.setCreatedAt(new Date());
        return com.UNCG_Fitness.UNCG_Fitness_Connect.report.reportRepository.save(report);
    }

    public Report updateReportStatus(int reportId, String status) {
        Optional<Report> reportOptional = com.UNCG_Fitness.UNCG_Fitness_Connect.report.reportRepository.findById(reportId);
        if (reportOptional.isPresent()) {
            Report report = reportOptional.get();
            report.setStatus(status);
            report.setUpdatedAt(new Date());
            return com.UNCG_Fitness.UNCG_Fitness_Connect.report.reportRepository.save(report);
        }
        return null;
    }

    public void deleteReportById(int reportId) {
        com.UNCG_Fitness.UNCG_Fitness_Connect.report.reportRepository.deleteById(reportId);
    }
}
