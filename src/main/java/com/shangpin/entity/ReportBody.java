package com.shangpin.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@EqualsAndHashCode
@Accessors(chain = true)
@ToString
/**
 * 规则信息类
 */
public class ReportBody {
    /**
     * 企业规则
     */
    List<RuleParam> enRule;
    /**
     * 企业信息
     */
    List<InformationParam> enInfor;

    /**
     * 个人规则
     */
    List<RuleParam> inRule;
    /**
     * 个人信息
     */
    List<InformationParam> inInfor;

    /**
     * 当前用户
     */

}
