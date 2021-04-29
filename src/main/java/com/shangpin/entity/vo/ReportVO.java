package com.shangpin.entity.vo;

import com.shangpin.entity.ReportDetail;

import java.math.BigDecimal;
import java.util.List;

/**
 * report model
 * @author wind
 * @date 2021/04/29 23:58:26
 * @version V1.0
 */
public class ReportVO {

    private Integer id;

    /** 查验申请编号*/
    private String applyId;

    /** 查验报告编号*/
    private String checkReportNo;

    /** 信用综合评分*/
    private BigDecimal creditCompositeScore;

    /** 综合评分等级 
    0 不合格
    1 合格
    2 良好
    3 优秀*/
    private Integer creditCompositeLevel;

    private List<ReportDetailVO> reportDetails;

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return this.id;
    }

    public void setApplyId(String applyId){
        this.applyId = applyId;
    }

    public String getApplyId(){
        return this.applyId;
    }

    public void setCheckReportNo(String checkReportNo){
        this.checkReportNo = checkReportNo;
    }

    public String getCheckReportNo(){
        return this.checkReportNo;
    }

    public void setCreditCompositeScore(BigDecimal creditCompositeScore){
        this.creditCompositeScore = creditCompositeScore;
    }

    public BigDecimal getCreditCompositeScore(){
        return this.creditCompositeScore;
    }

    public void setCreditCompositeLevel(Integer creditCompositeLevel){
        this.creditCompositeLevel = creditCompositeLevel;
    }

    public Integer getCreditCompositeLevel(){
        return this.creditCompositeLevel;
    }

    public List<ReportDetailVO> getReportDetails() {
        return reportDetails;
    }

    public void setReportDetails(List<ReportDetailVO> reportDetails) {
        this.reportDetails = reportDetails;
    }
}