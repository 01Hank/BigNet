package com.bignet.db.mapper;

import com.bignet.db.entity.BaseEntity;

import java.util.List;

public interface BaseMapper<T extends BaseEntity> {

    /**
     * 初始表
     */
    void initTable();

    /**
     * 保存数据
     * @param t
     */
    void save(T t);

    /**
     * 查询数据
     * @param uid
     * @return
     */
    List<T> getData(int uid);
}
