package com.cc.wolf.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cc.wolf.dao.UserGameDao;
import com.cc.wolf.entity.UserGame;
import com.cc.wolf.service.UserGameService;
import org.springframework.stereotype.Service;

@Service
public class UserGameServiceImpl extends ServiceImpl<UserGameDao, UserGame> implements UserGameService {
}

