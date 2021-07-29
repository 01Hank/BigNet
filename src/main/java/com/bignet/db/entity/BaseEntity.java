package com.bignet.db.entity;

/**
 * 基础数据类
 */
public abstract class BaseEntity {
    int uid;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}
