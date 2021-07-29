package com.bignet.util;


public class UUIDGenerate {
    public static int getUUID(){
        int result = new Long(System.currentTimeMillis()).intValue();
        result = result % 1000000;
        result = 1000000 + result;
        return result;
    }
}
