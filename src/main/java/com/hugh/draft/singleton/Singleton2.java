package com.hugh.draft.singleton;

/**
 * @Author Fly.Hugh
 * @Date 2020/7/14 4:31 下午
 * @Version 1.0
 **/
public class Singleton2 {
    /**
     * 懒汉式的单例
     * */
    private static volatile Singleton2 INSTANCE;
    private Singleton2(){}
    public static Singleton2 getInstance() {
        if(INSTANCE == null){
            synchronized (Singleton2.class){
                if (INSTANCE == null){
                    INSTANCE = new Singleton2();
                }
            }
        }
        return INSTANCE;
    }
}
