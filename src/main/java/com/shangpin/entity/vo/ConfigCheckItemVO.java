package com.shangpin.entity.vo;

import java.math.BigDecimal;

/**
 * config_check_item model
 * @author wind
 * @date 2021/04/30 07:27:46
 * @version V1.0
 */
public class ConfigCheckItemVO {

    private Integer id;

    /** 配置id*/
    private Integer configId;

    /** 检查项编号*/
    private String itemNo;

    /** 检查项名称*/
    private String itemName;

    /** 检查项描述*/
    private String summary;

    /** 检查项值类型
1-数值 2-布尔 3-枚举*/
    private Integer valueType;

    /** 允许值
valueType为1时，该项的格式为 最小值;最大值 */
    private String allowValue;

    /** 权值系数*/
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

    public void setItemNo(String itemNo){
        this.itemNo = itemNo;
    }

    public String getItemNo(){
        return this.itemNo;
    }

    public void setItemName(String itemName){
        this.itemName = itemName;
    }

    public String getItemName(){
        return this.itemName;
    }

    public void setSummary(String summary){
        this.summary = summary;
    }

    public String getSummary(){
        return this.summary;
    }

    public void setValueType(Integer valueType){
        this.valueType = valueType;
    }

    public Integer getValueType(){
        return this.valueType;
    }

    public void setAllowValue(String allowValue){
        this.allowValue = allowValue;
    }

    public String getAllowValue(){
        return this.allowValue;
    }

    public void setWeight(BigDecimal weight){
        this.weight = weight;
    }

    public BigDecimal getWeight(){
        return this.weight;
    }
}