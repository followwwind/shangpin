package com.shangpin.entity;

import java.io.Serializable;

/**
 * (IndividualReport)实体类
 *
 */
public class IndividualReport implements Serializable {
    private static final long serialVersionUID = 530419453712541221L;

    private Integer id;
    /**
     * 个人规则项
     */
    private String inrule;
    /**
     * 个人信息项
     */
    private String ininfor;
    /**
     * 归属用户
     */
    private String userEmail;

    private Integer checkId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInrule() {
        return inrule;
    }

    public void setInrule(String inrule) {
        this.inrule = inrule;
    }

    public String getIninfor() {
        return ininfor;
    }

    public void setIninfor(String ininfor) {
        this.ininfor = ininfor;
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
