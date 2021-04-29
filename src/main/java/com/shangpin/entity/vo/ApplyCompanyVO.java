package com.shangpin.entity.vo;

import java.util.Date;

/**
 * @package com.shangpin.entity
 * @className ApplyCompany
 * @note 申请公司查验实体类
 * @author wind
 * @date 2021/4/29 23:20
 */
public class ApplyCompanyVO {

    private String reqBatchNo;

    private String cert4SUCC;

    private String applyId;

    private Integer companyId;

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

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
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

    public String getCert4SUCC() {
        return cert4SUCC;
    }

    public void setCert4SUCC(String cert4SUCC) {
        this.cert4SUCC = cert4SUCC;
    }
}
