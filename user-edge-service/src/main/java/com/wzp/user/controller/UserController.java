package com.wzp.user.controller;

import com.wzp.thrift.user.UserInfo;
import com.wzp.user.response.Response;
import com.wzp.user.thrift.ServiceProvider;
import org.apache.thrift.TException;
import org.apache.tomcat.util.buf.HexUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author wuzph
 * @Date 2020/10/10 18:27
 */
@Controller
public class UserController {

    @Autowired
    private ServiceProvider serviceProvider;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Response login(@RequestParam("username")String username,
                      @RequestParam("password")String password){

        //1、验证用户名密码
        UserInfo userInfo = null;
        try {
            userInfo = serviceProvider.getUserService().getUserByName(username);
        } catch (TException e) {
            e.printStackTrace();
            return Response.USERNAME_PASSWORD_INVALID;
        }
        if(userInfo == null){
            return Response.USERNAME_PASSWORD_INVALID;
        }
        if(!userInfo.getPassword().equalsIgnoreCase(md5(password))){
            return Response.USERNAME_PASSWORD_INVALID;
        }
        //2、生成token
        String token = genToken();
        //3、缓存用户
        return null;
    }

    private String genToken() {
        return randomCode("0123456789abcdefghijklmnopqrstuvwxyz", 32);
    }

    private String randomCode(String s, int size) {
        StringBuilder result = new StringBuilder(size);

        Random random = new Random();
        for (int i = 0 ; i < size ; i++){
            int loc = random.nextInt(s.length());
            result.append(s.charAt(loc));
        }
        return result.toString();
    }

    private String md5(String password) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] digest = md5.digest(password.getBytes("utf-8"));
            return HexUtils.toHexString(digest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
