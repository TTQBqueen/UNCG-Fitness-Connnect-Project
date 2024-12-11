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
        return "/Admin/report-list";
        //return reportService.getAllReports();
    }
    // this will get a report by id
    @GetMapping("/{reportId}")
    public String getReportById(@PathVariable int reportId, Model model) {
        model.addAttribute("report", reportService.getReportById(reportId));
        return "/Admin/report-detail";
        //return reportService.getReportById(reportId);
    }

    // this will get all the reports by type (default is general)
    @GetMapping("")
    public String getReportsByType(@RequestParam(name = "type", defaultValue = "general") String reportType, Model model) {
        List<Report> reportList = reportService.getReportByType(reportType);
        model.addAttribute("reportsList", reportList);
        return "/Admin/report-list";
//        if(reportType == null) {
//            reportList = reportService.getReportByType(reportType);
//        } else reportList = reportService.getAllReports();
//        model.addAttribute("reportsList", reportList);
//        return "/Admin/report-list";
//        //return reportService.getReportByType(reportType);
    }
    @GetMapping("/new")
    public String showNewReportForm(Model model) {
        model.addAttribute("report", new Report());
        return "/Admin/report-new";
        //return reportService.addNewReport(report);
    }
    // this will add a new report
    @PostMapping("/new")
    public String addNewReport(Report report){
        reportService.addNewReport(report);
        return "redirect:/reports/all";
        //return reportService.addNewReport(report);
    }

    @GetMapping("/update/status/{reportId}")
    public String showUpdateReportForm(@PathVariable int reportId, Model model) {
        Report report = reportService.getReportById(reportId);
        model.addAttribute("report", report);
        return "/Admin/report-update";
    }

    @PostMapping("/update/status/{reportId}")
    public String updateReportStatus(@PathVariable int reportId, @RequestParam("status") String status) {
    reportService.updateReportStatus(reportId, status);
    return "redirect:/reports/all";
}

//    // this will update a report
//    @PutMapping("/update/status/{reportId}")
//    public String updateReportStatus(@PathVariable int reportId, @RequestParam("status") String status) {
//        reportService.updateReportStatus(reportId, status);
//        return "redirect:/reports/all";
//    }


    // this will delete a report
    @PostMapping("/delete/{reportId}")
    public String deleteReportById(@PathVariable int reportId){
        reportService.deleteReportById(reportId);
        return "redirect:/reports/all";
        //return reportService.getAllReports();
    }
}