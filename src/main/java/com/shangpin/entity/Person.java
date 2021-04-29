package com.shangpin.entity;


/**
 * person model
 * @author wind
 * @date 2021/04/29 22:22:37
 * @version V1.0
 */
public class Person {

    private Integer id;

    /** 交易主体账号*/
    private String tradeAccount;

    /** 姓名*/
    private String name;

    /** 手机号*/
    private String mobile;

    /** 身份证号*/
    private String certNum;

    /** 登记状态，*/
    private String status;

    /** 银行卡号*/
    private String bankAccount;

    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId(){
        return this.id;
    }

    public void setTradeAccount(String tradeAccount){
        this.tradeAccount = tradeAccount;
    }

    public String getTradeAccount(){
        return this.tradeAccount;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setMobile(String mobile){
        this.mobile = mobile;
    }

    public String getMobile(){
        return this.mobile;
    }

    public void setCertNum(String certNum){
        this.certNum = certNum;
    }

    public String getCertNum(){
        return this.certNum;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public String getStatus(){
        return this.status;
    }

    public void setBankAccount(String bankAccount){
        this.bankAccount = bankAccount;
    }

    public String getBankAccount(){
        return this.bankAccount;
    }
}