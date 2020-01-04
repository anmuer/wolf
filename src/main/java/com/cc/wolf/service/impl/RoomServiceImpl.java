package com.cc.wolf.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cc.wolf.dao.RoomDao;
import com.cc.wolf.entity.Room;
import com.cc.wolf.service.RoomService;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl extends ServiceImpl<RoomDao, Room> implements RoomService {
}

