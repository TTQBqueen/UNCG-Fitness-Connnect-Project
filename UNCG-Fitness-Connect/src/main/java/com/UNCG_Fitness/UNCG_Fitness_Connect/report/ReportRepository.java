package com.UNCG_Fitness.UNCG_Fitness_Connect.report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report, Integer> {
    //will return report type
    List<Report> findByReportType(String reportType);  


}