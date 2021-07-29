package com.bignet.db;


import com.bignet.db.mapper.BaseMapper;
import com.bignet.db.mapper.UserMapper;

/**
 * 所有表
 */
public enum TableEnum {
    USERINFO_TABLE("userInfo", UserMapper.class),
    ;
    String tableName;
    Class<? extends BaseMapper> tablePath;

    TableEnum(String tableName,Class tablePath) {
        this.tableName = tableName;
        this.tablePath = tablePath;
    }

    public String getTableName() {
        return tableName;
    }

    public Class getTablePath() {
        return tablePath;
    }
}
