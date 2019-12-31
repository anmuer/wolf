package com.cc.wolf.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cc.wolf.dao.UserDao;
import com.cc.wolf.entity.User;
import com.cc.wolf.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
}
