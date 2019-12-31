package com.cc.wolf.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cc.wolf.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends BaseMapper<User> {
}
