package com.shangpin.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;
import java.io.Serializable;

/**
 * 查验记录表(CheckRecord)实体类
 *
 */
@Data
@EqualsAndHashCode
@Accessors(chain = true)
public class CheckRecord implements Serializable {
    private static final long serialVersionUID = -96977511519987560L;

    private Integer id;
    /**
     * 企业名
     */
    private String name;
    /**
     * 账号
     */
    private String account;
    /**
     * 类型个人或企业
     */
    private String type;
    /**
     * 信用分
     */
    private Double creditScore;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 历史记录
     */
    private Integer history;
    /**
     * 企业code
     */
    private String code;
    /**
     * 法人
     */
    private String folk;

    /**
     * 合格
     */
    private String qualified;
    /**
     * 银行卡
     */
    private String accountNo;
}
