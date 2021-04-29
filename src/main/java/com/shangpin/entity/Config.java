package com.shangpin.entity;

import java.math.BigDecimal;

/**
 * config model
 * @author wind
 * @date 2021/04/30 07:27:46
 * @version V1.0
 */
public class Config {

    private Integer id;

    /** 配置编号*/
    private String configNo;

    /** 交易平台编号*/
    private String platformId;

    /** 查验类型 1-个人 2-企业*/
    private Integer checkType;

    /** 生效时间，
格式：yyyyMMddHHmmss*/
    private String applyTime;

    /** 合格分数线*/
    private BigDecimal passLine;

    /** 良好分数线*/
    private BigDecimal goodLine;

    /** 优秀分数线*/
    private BigDecimal excellentLine;

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return this.id;
    }

    public void setConfigNo(String configNo){
        this.configNo = configNo;
    }

    public String getConfigNo(){
        return this.configNo;
    }

    public void setPlatformId(String platformId){
        this.platformId = platformId;
    }

    public String getPlatformId(){
        return this.platformId;
    }

    public void setCheckType(Integer checkType){
        this.checkType = checkType;
    }

    public Integer getCheckType(){
        return this.checkType;
    }

    public void setApplyTime(String applyTime){
        this.applyTime = applyTime;
    }

    public String getApplyTime(){
        return this.applyTime;
    }

    public void setPassLine(BigDecimal passLine){
        this.passLine = passLine;
    }

    public BigDecimal getPassLine(){
        return this.passLine;
    }

    public void setGoodLine(BigDecimal goodLine){
        this.goodLine = goodLine;
    }

    public BigDecimal getGoodLine(){
        return this.goodLine;
    }

    public void setExcellentLine(BigDecimal excellentLine){
        this.excellentLine = excellentLine;
    }

    public BigDecimal getExcellentLine(){
        return this.excellentLine;
    }
}