package com.bignet.db.mapper;

import com.bignet.db.entity.impl.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User>{
    /**
     * 获取所有用户
     * @return
     */
    List<User> findAll();
}
