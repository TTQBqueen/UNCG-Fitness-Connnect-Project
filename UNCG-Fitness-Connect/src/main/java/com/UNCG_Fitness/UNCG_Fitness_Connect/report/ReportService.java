package com.UNCG_Fitness.UNCG_Fitness_Connect.report;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }
}

//    public Report getReportById(int reportId){
//        return reportRepository.findById(reportId).orElse(null);
//    }
//    public List<Report> getReportByType(String reportType){
//        return reportRepository.findByReportType(reportType);
//    }
//    public Report addNewReport(Report report){
//        report.setCreatedAt(new Date());
//        return reportRepository.save(report);
//    }
//    public Report updateReportStatus(int reportId, String status){
//        Optional<Report> reportOptional = reportRepository.findById(reportId);
//        if(reportOptional.isPresent()){
//            Report report = reportOptional.get();
//            report.setStatus(status);
//            report.setUpdatedAt(new Date());
//            return reportRepository.save(report);
//    }
//    return null;
//    }
//    public void deleteReportById(int reportId){
//        reportRepository.deleteById(reportId);
//    }}
