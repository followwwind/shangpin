package com.shangpin.entity.vo;


/**
 * 企业信息查询
 * @author wind
 * @date 2021/04/29 22:22:37
 * @version V1.0
 */
public class CompanyVO {

    private String applyId;

    private String cert4SUCC;

    /**
     * success/fail
     */
    private String returnCode;
    /**
     * 通讯错误信息
     */
    private String returnMsg;

    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId;
    }

    public String getCert4SUCC() {
        return cert4SUCC;
    }

    public void setCert4SUCC(String cert4SUCC) {
        this.cert4SUCC = cert4SUCC;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }
}