package com.UNCG_Fitness.UNCG_Fitness_Connect.report;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model; 


import java.util.List;

@Controller
@RequestMapping("/reports")
public class ReportController{

    @Autowired
    private ReportService reportService;

    // this will get all the reports
    @GetMapping("/all")
    //public List<Report> getAllReports() { 
    public String getAllReports(Model model) { 
        model.addAttribute("reportsList", reportService.getAllReports());
        return "report-list";
        //return reportService.getAllReports();
    } 
    // this will get a report by id
    @GetMapping("/{reportId}")
    public String getReportById(@PathVariable int reportId, Model model) {
        model.addAttribute("report", reportService.getReportById(reportId));
        return "report-detail";
        //return reportService.getReportById(reportId);
    } 

    // this will get all the reports by type (default is general)
    @GetMapping("")
    public String getReportsByType(@RequestParam(name = "type", defaultValue = "general") String reportType, Model model) {
        List<Report> reportList;
        if(reportType == null) { 
            reportList = reportService.getReportByType(reportType);
        } else reportList = reportService.getAllReports();
        model.addAttribute("reportsList", reportList); 
        return "report-list";
        //return reportService.getReportByType(reportType);
    } 
    // this will add a new report
    @PostMapping("/new")
    public String addNewReport(Report report){
        reportService.addNewReport(report);
        return "redirect:/reports/all";
        //return reportService.addNewReport(report);
    } 

    // this will update a report
    @PutMapping("/update/status/{reportId}")
    public String updateReportStatus(@PathVariable int reportId, @RequestBody String status, Model model) {
        model.addAttribute("status", reportService.getReportById(reportId));
        return "report-update";
        // return reportService.updateReportStatus(reportId, status);
    } 

    // this will delete a report
    @DeleteMapping("/delete/{reportId}")
    public String deleteReportById(@PathVariable int reportId){
        reportService.deleteReportById(reportId);
        return "redirect:/reports/all";
        //return reportService.getAllReports();
    }
}