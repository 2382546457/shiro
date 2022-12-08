package com.xiaohe.demo.domain.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author : 小何
 * @Description :
 * @date : 2022-12-08 15:03
 */
@Data
public class RegisterUserVo {
    /**
     * 身份证号
     */
    private String id;

    /**
     * 用户手机号
     */
    private String phone;


    /**
     * 用户姓名
     */
    @NotNull(message = "姓名不能为空")
    private String name;

    /**
     * 用户密码
     */
    @NotNull(message = "密码不能为空")
    private String password;
}
