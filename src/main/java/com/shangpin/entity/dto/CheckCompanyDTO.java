package com.shangpin.entity.dto;

import java.util.List;

/**
 * @package com.shangpin.entity.dto
 * @className CheckCompanyDTO
 * @note 综合服务平台发起企业类型的交易主体信息查验。
 * @author wind
 * @date 2021/4/29 23:04
 */
public class CheckCompanyDTO {

    private String reqBatchNo;

    private List<CompanyDTO> items;

    public String getReqBatchNo() {
        return reqBatchNo;
    }

    public void setReqBatchNo(String reqBatchNo) {
        this.reqBatchNo = reqBatchNo;
    }

    public List<CompanyDTO> getItems() {
        return items;
    }

    public void setItems(List<CompanyDTO> items) {
        this.items = items;
    }
}
