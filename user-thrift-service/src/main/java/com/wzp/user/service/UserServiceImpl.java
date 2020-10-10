package com.wzp.user.service;

import com.wzp.thrift.user.UserInfo;
import com.wzp.thrift.user.UserService;
import com.wzp.user.mapper.UserMapper;
import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserServiceImpl
 * @Description 实现用户api接口
 * @Author wuzph
 * @Date 2020/10/10 15:29
 */
@Service
public class UserServiceImpl implements UserService.Iface{

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserInfo getUserById(int id) throws TException {
        return userMapper.getUserById(id);
    }

    @Override
    public UserInfo getUserByName(String username) throws TException {
        return userMapper.getUserByName(username);
    }

    @Override
    public void registerUser(UserInfo userInfo) throws TException {
        userMapper.registerUser(userInfo);
    }
}
