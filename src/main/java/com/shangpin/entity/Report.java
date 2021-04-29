package com.shangpin.entity;

import java.math.BigDecimal;

/**
 * report model
 * @author wind
 * @date 2021/04/29 23:58:26
 * @version V1.0
 */
public class Report {

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
}