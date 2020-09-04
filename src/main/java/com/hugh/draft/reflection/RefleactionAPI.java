package com.hugh.draft.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;

/**
 * @program: draft
 * @description: 反射
 * @author: Fly.Hugh
 * @create: 2020-09-04 14:29
 **/
public class RefleactionAPI {
    public static void main(String[] args) throws Exception{
        URL url = new URL("https://www.baidu.com");
        String urlString = url.toExternalForm();
        System.out.println(urlString);

        System.out.println();
        System.out.println("==============等价==============>");
        System.out.println();

        Class<?> type = Class.forName("java.net.URL");
        Constructor<?> constructor = type.getConstructor(String.class);
        Object instance = constructor.newInstance("https://www.baidu.com");
        Method method = type.getMethod("toExternalForm");
        Object methodCallResult = method.invoke(instance);

        System.out.println(methodCallResult);
    }
}
