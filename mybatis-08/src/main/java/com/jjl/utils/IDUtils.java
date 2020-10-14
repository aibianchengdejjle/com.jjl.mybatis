package com.jjl.utils;
import org.apache.ibatis.annotations.ResultType;

import java.util.UUID;

public class IDUtils {
    public static  String getid(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
