package com.UNCG_Fitness.UNCG_Fitness_Connect.report;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Integer> {
    List<Report> findByReportType(String reportType);

}