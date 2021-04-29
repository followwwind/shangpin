package com.shangpin.entity.vo;

import java.util.Date;

/**
 * @package com.shangpin.entity
 * @className ApplyCompany
 * @note 申请个人查验实体类
 * @author wind
 * @date 2021/4/29 23:20
 */
public class ApplyPersonVO {

    private String reqBatchNo;

    private String applyId;

    private String name;

    private Integer personId;

    private Integer status;

    private Date createTime;

    public String getReqBatchNo() {
        return reqBatchNo;
    }

    public void setReqBatchNo(String reqBatchNo) {
        this.reqBatchNo = reqBatchNo;
    }

    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
