package com.hugh.draft;

/**
 * @program: draft
 * @description: 单例
 * @author: Fly.Hugh
 * @create: 2020-07-14 01:15
 **/
public class Singleton {
    //懒汉式
    private static Singleton instance;

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
