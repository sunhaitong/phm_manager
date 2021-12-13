package com.chaos.manager.controller;

import com.chaos.manager.entity.Result;
import com.chaos.manager.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunht
 * @date 2021/12/7
 */
@Slf4j
@RestController
@RequestMapping("user")
public class LoginController {
    @PostMapping("login")
    public Result login(@RequestBody UserEntity userEntity) {
        if (userEntity.login()) {
            return Result.success("登陆成功");
        } else {
            return Result.error("登陆失败", 704);
        }
    }
}
