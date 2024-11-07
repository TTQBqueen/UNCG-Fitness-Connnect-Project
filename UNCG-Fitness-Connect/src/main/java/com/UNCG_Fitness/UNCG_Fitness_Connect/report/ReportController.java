package com.UNCG_Fitness.UNCG_Fitness_Connect.report;  

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List; 

@RestController 
@RequestMapping("/reports") 
public class ReportController{ 
    @Autowired
    private ReportService service; 

    @GetMapping("/all")
    public List<Report> getAllReports() {
        return service.getAllReports();
    } 
    @GetMapping("/{reportId}") 
    public Report getReportById(@PathVariable int reportId) { 
        return service.getReportById(reportId);
    } 
    @GetMapping("") 
    public List<Report> getReportsByType(@RequestParam(name = "type", defaultValue = "general") String reportType) { 
        return service.getReportByType(reportType); 
    } 
    @PostMapping("/new") 
    public Report addNewReport(@RequestBody Report report){ 
        return service.addNewReport(report); 
    } 
    @PutMapping("/update/status/{reportId}") 
    public Report updateReportStatus(@PathVariable int reportId, @RequestBody String status) {
        return service.updateReportStatus(reportId, status); 
    }  
    @DeleteMapping("/delete/{reportId}") 
    public List<Report> deleteReportById(@PathVariable int reportId){ 
        service.deleteReportById(reportId);
        return service.getAllReports();
    }
}
