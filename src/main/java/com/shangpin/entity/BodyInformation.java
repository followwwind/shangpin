package com.shangpin.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode
@Accessors(chain = true)
public class BodyInformation {
    /**
     * 查验主体编号
     */
    private String bodyNum;
    /**
     * 交易平台名称
     */
    private String tradeName;
    /**
     * 准入规则版本
     */
    private String permitPublic;
    /**
     * 生成时间
     */
    private String time;

    /**
     * 企业名称
     */
    private String name;
    /**
     * 证件类型
     */
    private String type;
    /**
     * 证件号
     */
    private String number;
    /**
     * 法人
     */
    private String folk;
    /**
     * 手机号
     */
    private String phone;

}
