package com.cloud.system.service.impl;

import com.cloud.system.domain.User;
import com.cloud.system.mapper.UserMapper;
import com.cloud.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User getUser() {
        return userMapper.getUser();
    }
}
