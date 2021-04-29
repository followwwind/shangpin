package com.shangpin.entity.dto;

import java.util.List;

/**
 * @package com.shangpin.entity.dto
 * @className ReportDTO
 * @note 报告查询
 * @author wind
 * @date 2021/4/29 23:57
 */
public class ReportDTO {

    private String reqBatchNo;

    private List<ApplyDTO> item;

    public String getReqBatchNo() {
        return reqBatchNo;
    }

    public void setReqBatchNo(String reqBatchNo) {
        this.reqBatchNo = reqBatchNo;
    }

    public List<ApplyDTO> getItem() {
        return item;
    }

    public void setItem(List<ApplyDTO> item) {
        this.item = item;
    }
}
