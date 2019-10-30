package com.util;

import java.util.List;

public class JSON {
    public static String toJson(List<String> list) {
        String data = "";
        int count=1;
        for (String str : list) {
            // "1":"title1","2":"title2",
            data+="\""+count+"\":\""+str+"\",";
            count++;
        }
        data+="\"length\":"+count;
        return "{"+data+"}";
    }
}
