package com.hugh.draft.singleton;

/**
 * @Author Fly.Hugh
 * @Date 2020/7/14 3:08 下午
 * @Version 1.0
 **/
public class Singleton1 {
    private static Singleton1 INSTANCE;
    private Singleton1(){}
    public static Singleton1 getInstance(){
        if(INSTANCE == null){
            synchronized (Singleton1.class) {
                if(INSTANCE == null) {
                    INSTANCE = new Singleton1();
                }
            }
        }
        return INSTANCE;
    }
}