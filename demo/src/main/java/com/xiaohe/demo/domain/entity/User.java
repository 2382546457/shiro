package com.xiaohe.demo.domain.entity;

import lombok.Data;

@Data
public class User {
    /**
     * 用户手机号,主键
     */
    private String phone;
    /**
     * 用户姓名
     */
    private String name;
    /**
     * 性别
     */
    private char sex;
    /**
     * 用户昵称
     */
    private String username;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 用户住址
     */
    private String address;
    /**
     * 账号是否可用
     */
    private Integer enabled;
}
