package com.UNCG_Fitness.UNCG_Fitness_Connect.report;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "report")

public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int reportId;

    @Column(nullable = false)
    private int contentId;

    @Column(nullable = false)
    private int reporterId;

    @Column(nullable = false)
    private String reportType;

    @Column(nullable = false)
    private String reason;

    private Date createdAt;

    private Date updatedAt;

    private String status;

    public Report(String reason) {
        this.reason = reason;
    }

    public int getId() {
        return reportId;
    }



    public Report(int reportId, int contentId, int reporterId, String reportType, String reason, Date createdAt, Date updatedAt, String status) {
        this.reportId = reportId;
        this.contentId = contentId;
        this.reporterId = reporterId;
        this.reportType = reportType;
        this.reason = reason;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.status = status;
    }
    public Report(String reportType, String reason, Date createdAt, Date updatedAt, String status) {
        this.reportType = reportType;
        this.reason = reason;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.status = status;
    }
    public Report(){
    }
    public int getReportId(){
        return reportId;
    }
    public void setReportId(int reportId){
        this.reportId = reportId;
    }
    public int getContentId(){
        return contentId;
    }
    public void setContentId(int contentId){
        this.contentId = contentId;
    }
    public int getReporterId(){
        return reporterId;
    }
    public void setReporterId(int reporterId){
        this.reporterId = reporterId;
    }
    public String getReportType(){
        return reportType;
    }
    public void setReportType(String reportType){
        this.reportType = reportType;
    }
    public String getReason(){
        return reason;
    }
    public void setReason(String reason){
        this.reason = reason;
    }
    public Date getCreatedAt(){
        return createdAt;
    }
    public void setCreatedAt(Date createdAt){
        this.createdAt = createdAt;
    }
    public Date getUpdatedAt(){
        return updatedAt;
    }
    public void setUpdatedAt(Date updatedAt){
        this.updatedAt = updatedAt;
    }
    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }
}