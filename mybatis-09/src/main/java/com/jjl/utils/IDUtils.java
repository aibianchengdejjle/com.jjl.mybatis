package com.jjl.utils;

import java.util.UUID;

public class IDUtils {
    public static  String getid(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
