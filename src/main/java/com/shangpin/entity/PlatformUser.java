package com.shangpin.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * 平台用户对象 platform_user
 *
 * @author 墨洛
 * @date 2020-11-26
 */
@Data
@EqualsAndHashCode
@Accessors(chain = true)
@ToString
/**
 * 我上面的那些注释就是用来生成getter setter 的,只不过你idea没装插件他报错
 */
public class PlatformUser {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 平台名称
     */
    private String name;

    /**
     * 平台邮箱
     */
    private String email;

    /**
     * 备案网址
     */
    private String site;

    /**
     * 备案域名
     */
    private String domainname;

    /**
     * 备案号
     */
    private String recordno;

    /**
     * 经营范围
     */
    private String businessscope;

    /**
     * 注册密码
     */
    private String password;

    /**
     * 锁定状态0锁定 1未锁定
     */
    private Integer lockedstate;


}
