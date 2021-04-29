package com.shangpin.entity.vo;


/**
 * 企业信息查询
 * @author wind
 * @date 2021/04/29 22:22:37
 * @version V1.0
 */
public class ApplyVO {

    private String applyId;

    /**
     * 查验结果 1：成功 2-失败 3-查验中 4-无记录
     */
    private Integer returnCode;
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

    public Integer getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(Integer returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMsg() {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg;
    }
}