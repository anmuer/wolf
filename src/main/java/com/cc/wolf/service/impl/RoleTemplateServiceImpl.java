package com.cc.wolf.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cc.wolf.dao.RoleTemplateDao;
import com.cc.wolf.entity.RoleTemplate;
import com.cc.wolf.service.RoleTemplateService;
import org.springframework.stereotype.Service;

@Service
public class RoleTemplateServiceImpl extends ServiceImpl<RoleTemplateDao, RoleTemplate> implements RoleTemplateService {
}

