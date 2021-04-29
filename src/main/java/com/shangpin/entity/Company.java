package com.shangpin.entity;


/**
 * company model
 * @author wind
 * @date 2021/04/29 22:22:37
 * @version V1.0
 */
public class Company {

    private Integer id;

    /** 交易主体账号*/
    private String tradeAccount;

    /** 社会统一信用代码*/
    private String cert4SUCC;

    /** 法定代表人*/
    private String legalPerson;

    /** 公司名称*/
    private String companyName;

    /** 登记状态，需要列举一下登记状态的所有值及每个值对应的状态码*/
    private String status;

    /** 成立日期，
格式：yyyyMMdd*/
    private String foundingDate;

    /** 注册资本（单位：万元）*/
    private Integer registeredCapital;

    /** 所属行业*/
    private String industry;

    /** 营业期限*/
    private String period;

    /** 经营范围*/
    private String scope;

    /** 经营地址*/
    private String address;

    /** 信息变更时间
格式：yyyyMMddHHmmss*/
    private String changeTime;

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

    public void setCert4SUCC(String cert4SUCC){
        this.cert4SUCC = cert4SUCC;
    }

    public String getCert4SUCC(){
        return this.cert4SUCC;
    }

    public void setLegalPerson(String legalPerson){
        this.legalPerson = legalPerson;
    }

    public String getLegalPerson(){
        return this.legalPerson;
    }

    public void setCompanyName(String companyName){
        this.companyName = companyName;
    }

    public String getCompanyName(){
        return this.companyName;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public String getStatus(){
        return this.status;
    }

    public void setFoundingDate(String foundingDate){
        this.foundingDate = foundingDate;
    }

    public String getFoundingDate(){
        return this.foundingDate;
    }

    public void setRegisteredCapital(Integer registeredCapital){
        this.registeredCapital = registeredCapital;
    }

    public Integer getRegisteredCapital(){
        return this.registeredCapital;
    }

    public void setIndustry(String industry){
        this.industry = industry;
    }

    public String getIndustry(){
        return this.industry;
    }

    public void setPeriod(String period){
        this.period = period;
    }

    public String getPeriod(){
        return this.period;
    }

    public void setScope(String scope){
        this.scope = scope;
    }

    public String getScope(){
        return this.scope;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getAddress(){
        return this.address;
    }

    public void setChangeTime(String changeTime){
        this.changeTime = changeTime;
    }

    public String getChangeTime(){
        return this.changeTime;
    }
}