package com.shangpin.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@EqualsAndHashCode
@Accessors(chain = true)
public class CheckParam {
    /**
     * 条件
     */
    private List<RuleParam> ruleList;
    /**
     * 需要展示的信息
     */
    private List<InformationParam> information;

    /**
     * 公司名
     */
    private String name;

    /**
     * 三码(注册号 /组织机构代码 /统一社会信用代码)
     */
    private String code;

    /**
     * 法人
     */
    private String legalPersonName;

    /**
     * 查验规则id
     */
    private Integer reportId;

}
