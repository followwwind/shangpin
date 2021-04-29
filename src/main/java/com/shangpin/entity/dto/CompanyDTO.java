package com.shangpin.entity.dto;


/**
 * 企业信息查询
 * @author wind
 * @date 2021/04/29 22:22:37
 * @version V1.0
 */
public class CompanyDTO {

    private String applyId;

    /** 交易主体账号*/
    private String tradeAccount;

    /** 社会统一信用代码*/
    private String cert4SUCC;

    /** 法定代表人*/
    private String legalPerson;

    /** 公司名称*/
    private String companyName;

    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId;
    }

    public String getTradeAccount() {
        return tradeAccount;
    }

    public void setTradeAccount(String tradeAccount) {
        this.tradeAccount = tradeAccount;
    }

    public String getCert4SUCC() {
        return cert4SUCC;
    }

    public void setCert4SUCC(String cert4SUCC) {
        this.cert4SUCC = cert4SUCC;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}