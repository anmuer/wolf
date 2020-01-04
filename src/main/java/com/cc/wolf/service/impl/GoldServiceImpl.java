package com.cc.wolf.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cc.wolf.dao.GameDao;
import com.cc.wolf.dao.GoldDao;
import com.cc.wolf.entity.Game;
import com.cc.wolf.entity.Gold;
import com.cc.wolf.service.GameService;
import com.cc.wolf.service.GoldService;
import org.springframework.stereotype.Service;

@Service
public class GoldServiceImpl extends ServiceImpl<GoldDao, Gold> implements GoldService {
}

