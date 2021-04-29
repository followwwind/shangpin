package com.shangpin.entity.vo;


/**
 * 企业信息查询
 * @author wind
 * @date 2021/04/29 22:22:37
 * @version V1.0
 */
public class PersonVO {

    private String applyId;

    private String name;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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