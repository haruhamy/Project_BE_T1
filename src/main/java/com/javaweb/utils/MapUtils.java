package com.javaweb.utils;

import java.util.Map;

public class MapUtils {

    public static <T> T getObject(Map<String, Object> params, String key, Class<T> tClass) {
        Object object = params.getOrDefault(key, null);

        if (object != null) {
            if (tClass.getTypeName().equals("java.lang.Long")) {
                object = !object.equals("") ? Long.valueOf(object.toString()) : null; // chuyển đổi value phù hợp với tClass yêu cầu
            } else if (tClass.getTypeName().equals("java.lang.Integer")) {
                object = !object.equals("") ? Integer.valueOf(object.toString()) : null;
            } else if (tClass.getTypeName().equals("java.lang.String")) {
                object = !object.equals("") ? object.toString() : null;
            }

            return tClass.cast(object); // cast kiểu trả về
        }

        return null;
    }
}

