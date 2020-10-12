package com.wzp.user.response;

/**
 * @ClassName LoginResponse
 * @Description TODO
 * @Author wuzph
 * @Date 2020/10/12 10:21
 */

public class LoginResponse extends Response{

    private String token;

    public LoginResponse(String token){
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
