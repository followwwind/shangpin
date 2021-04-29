package com.shangpin.entity.dto;

import java.util.List;

/**
 * @package com.shangpin.entity.dto
 * @className BatchCompanyDTO
 * @note 批量查询
 * @author wind
 * @date 2021/4/29 22:33
 */
public class BatchCompanyDTO {

    private List<CompanyDTO> items;

    public List<CompanyDTO> getItems() {
        return items;
    }

    public void setItems(List<CompanyDTO> items) {
        this.items = items;
    }
}
