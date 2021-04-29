package com.shangpin.entity.dto;

import java.util.List;

/**
 * @package com.shangpin.entity.dto
 * @className CheckCompanyDTO
 * @note 综合服务平台发起企业类型的交易主体信息查验。
 * @author wind
 * @date 2021/4/29 23:04
 */
public class CheckPersonDTO {

    private String reqBatchNo;

    private List<PersonDTO> items;

    public String getReqBatchNo() {
        return reqBatchNo;
    }

    public void setReqBatchNo(String reqBatchNo) {
        this.reqBatchNo = reqBatchNo;
    }

    public List<PersonDTO> getItems() {
        return items;
    }

    public void setItems(List<PersonDTO> items) {
        this.items = items;
    }
}
