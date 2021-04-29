package com.shangpin.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode
@Accessors(chain = true)
public class PersonParam {
    /**
     * 姓名
     */
    private String name;
    /**
     * 身份证
     */
    private String idCard;
    /**
     * 银行卡
     */
    private String accountNo;
    /**
     * 预留手机号
     */
    private String bankPreMobile;
    /**
     * 查验规则id
     */
    private Integer reportId;
}
