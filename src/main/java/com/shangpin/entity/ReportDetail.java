package com.shangpin.entity;

import java.math.BigDecimal;

/**
 * report_detail model
 * @author wind
 * @date 2021/04/29 23:58:26
 * @version V1.0
 */
public class ReportDetail {

    private Integer id;

    /** 报告id*/
    private Integer reportId;

    /** 查验项目编号*/
    private String checkItemNo;

    /** 查验类型 
1-准入配置查验 
2-动态查验*/
    private Integer checkType;

    /** 实际值
  多个值之间使用英文的分号“;”进行分割*/
    private String realValue;

    /** 报告描述*/
    private String reportInfo;

    /** 该查验项目得分*/
    private BigDecimal itemScore;

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return this.id;
    }

    public void setReportId(Integer reportId){
        this.reportId = reportId;
    }

    public Integer getReportId(){
        return this.reportId;
    }

    public void setCheckItemNo(String checkItemNo){
        this.checkItemNo = checkItemNo;
    }

    public String getCheckItemNo(){
        return this.checkItemNo;
    }

    public void setCheckType(Integer checkType){
        this.checkType = checkType;
    }

    public Integer getCheckType(){
        return this.checkType;
    }

    public void setRealValue(String realValue){
        this.realValue = realValue;
    }

    public String getRealValue(){
        return this.realValue;
    }

    public void setReportInfo(String reportInfo){
        this.reportInfo = reportInfo;
    }

    public String getReportInfo(){
        return this.reportInfo;
    }

    public void setItemScore(BigDecimal itemScore){
        this.itemScore = itemScore;
    }

    public BigDecimal getItemScore(){
        return this.itemScore;
    }
}