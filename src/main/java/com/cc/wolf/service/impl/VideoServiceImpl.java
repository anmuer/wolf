package com.cc.wolf.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cc.wolf.dao.VideoDao;
import com.cc.wolf.entity.Video;
import com.cc.wolf.service.GameService;
import com.cc.wolf.service.VideoService;
import org.springframework.stereotype.Service;

@Service
public class VideoServiceImpl extends ServiceImpl<VideoDao, Video> implements VideoService {
}

