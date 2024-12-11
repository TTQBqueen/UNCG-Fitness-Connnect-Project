package com.UNCG_Fitness.UNCG_Fitness_Connect.report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

public interface reportRepository extends JpaRepository<Report, Integer> {
    List<Report> findByReportType(String reportType);

}