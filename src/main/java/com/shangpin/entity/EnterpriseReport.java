package com.shangpin.entity;

import java.io.Serializable;

/**
 * 企业和个人规则信息项(EnterpriseReport)实体类
 *
 */
public class EnterpriseReport implements Serializable {
    private static final long serialVersionUID = 644969588626738199L;

    private Integer id;
    /**
     * 企业规则项
     */
    private String enrule;
    /**
     * 企业信息项
     */
    private String eninfor;
    /**
     * 归属用户id
     */
    private String userEmail;
    /**
     * 归属检验报告id
     */
    private Integer checkId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEnrule() {
        return enrule;
    }

    public void setEnrule(String enrule) {
        this.enrule = enrule;
    }

    public String getEninfor() {
        return eninfor;
    }

    public void setEninfor(String eninfor) {
        this.eninfor = eninfor;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Integer getCheckId() {
        return checkId;
    }

    public void setCheckId(Integer checkId) {
        this.checkId = checkId;
    }

}
