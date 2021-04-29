package com.shangpin.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode
@Accessors(chain = true)
public class InformationParam {
    /**
     * 字段名
     */
    private String text;

    /**
     * 是否选中
     */
    private boolean selected;

    /**
     * 值
     */
    private String value;


}
