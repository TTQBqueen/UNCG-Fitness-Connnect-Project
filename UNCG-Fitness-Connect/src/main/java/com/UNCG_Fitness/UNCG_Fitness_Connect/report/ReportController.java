package com.UNCG_Fitness.UNCG_Fitness_Connect.report;

import jakarta.persistence.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller; 

import java.util.List;

@Controller
@RequestMapping("/reports")
public class ReportController{
    @Autowired
    private ReportService reportService;

    @GetMapping("/all")
    public List<Report> getAllReports() {
        return reportService.getAllReports();
    }
    @GetMapping("/{reportId}")
    public Report getReportById(@PathVariable int reportId) {
        return reportService.getReportById(reportId);
    }
    @GetMapping("")
    public List<Report> getReportsByType(@RequestParam(name = "type", defaultValue = "general") String reportType) {
        return reportService.getReportByType(reportType);
    }
    @PostMapping("/new")
    public Report addNewReport(@RequestBody Report report){
        return reportService.addNewReport(report);
    }
    @PutMapping("/update/status/{reportId}")
    public Report updateReportStatus(@PathVariable int reportId, @RequestBody String status) {
        return reportService.updateReportStatus(reportId, status);
    }
    @DeleteMapping("/delete/{reportId}")
    public List<Report> deleteReportById(@PathVariable int reportId){
        reportService.deleteReportById(reportId);
        return reportService.getAllReports();
    }
}