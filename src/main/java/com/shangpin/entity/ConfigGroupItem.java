package com.shangpin.entity;

import java.math.BigDecimal;

/**
 * config_group_item model
 * @author wind
 * @date 2021/04/30 07:27:46
 * @version V1.0
 */
public class ConfigGroupItem {

    private Integer id;

    /** 配置id*/
    private Integer configId;

    /** 编号*/
    private String groupNo;

    /** 名称*/
    private String groupName;

    /** 及格分数线*/
    private BigDecimal passLine;

    /** 分组权重*/
    private BigDecimal weight;

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return this.id;
    }

    public void setConfigId(Integer configId){
        this.configId = configId;
    }

    public Integer getConfigId(){
        return this.configId;
    }

    public void setGroupNo(String groupNo){
        this.groupNo = groupNo;
    }

    public String getGroupNo(){
        return this.groupNo;
    }

    public void setGroupName(String groupName){
        this.groupName = groupName;
    }

    public String getGroupName(){
        return this.groupName;
    }

    public void setPassLine(BigDecimal passLine){
        this.passLine = passLine;
    }

    public BigDecimal getPassLine(){
        return this.passLine;
    }

    public void setWeight(BigDecimal weight){
        this.weight = weight;
    }

    public BigDecimal getWeight(){
        return this.weight;
    }
}