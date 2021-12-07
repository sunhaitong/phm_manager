package com.chaos.manager.entity;

import lombok.Data;

/**
 * @author sunht
 * @date 2021/12/7
 */
@Data
public class UserEntity {
    private String userName;
    private String password;

    public boolean login() {
        return this.userName.equals("admin") && this.password.equals("Qwer1234");
    }
}
