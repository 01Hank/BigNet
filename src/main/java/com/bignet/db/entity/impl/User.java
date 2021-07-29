package com.bignet.db.entity.impl;

import com.bignet.db.entity.BaseEntity;

public class User extends BaseEntity {
    String name;

    int passward;

    String email;

    byte[] data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPassward() {
        return passward;
    }

    public void setPassward(int passward) {
        this.passward = passward;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
