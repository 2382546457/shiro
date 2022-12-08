package com.xiaohe.demo.controller;

import com.xiaohe.demo.domain.entity.User;
import com.xiaohe.demo.domain.vo.RegisterUserVo;
import com.xiaohe.demo.util.VerifyUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


/**
 * @author : 小何
 * @Description :
 * @date : 2022-12-08 15:11
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/register")
    public String register(@RequestBody @Validated RegisterUserVo userVo) {
        // 获取身份证号以及手机号
        String id = userVo.getId();
        String phone = userVo.getPhone();
        if (!VerifyUtils.isPhoneLegal(phone)) {
            return "手机号格式错误";
        }
        if (!VerifyUtils.isIdCardLegal(id)) {
            return "身份证号格式错误";
        }

        // 一系列与数据库的交互...


        // 交互完成..
        return "成功注册!";
    }
}
