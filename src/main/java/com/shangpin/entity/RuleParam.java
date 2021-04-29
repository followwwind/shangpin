package com.shangpin.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode
@Accessors(chain = true)
public class RuleParam {
    /**
     * 字段名
     */
    private String text;

    /**
     * 子字段名
     */
    private String content;

    /**
     * 是否选中
     */
    private Boolean selected;

    /**
     * 权重
     */
    private String rate;

    /**
     * 实际值
     */
    private String act_result;

    /**
     * 是否符合
     */
    private String result;

    /**
     * true=必要,false=附加
     */
    private Boolean dis;
}
