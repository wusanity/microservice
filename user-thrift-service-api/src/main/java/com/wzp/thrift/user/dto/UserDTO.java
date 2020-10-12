package com.wzp.thrift.user.dto;

import java.io.Serializable;

/**
 * @ClassName UserDTO
 * @Description TODO
 * @Author wuzph
 * @Date 2020/10/12 10:13
 */

public class UserDTO implements Serializable {

    private int id;
    private String username;
    private String password;
    private String mobile;
    private String email;
    private String realName;

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getRealName() {
        return realName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
}
