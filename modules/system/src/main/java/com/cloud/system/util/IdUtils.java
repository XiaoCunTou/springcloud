package com.cloud.system.util;

import java.util.UUID;

public class IdUtils {

    public static String UUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
