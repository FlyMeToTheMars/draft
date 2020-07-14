package com.hugh.draft.singleton;

/**
 * @Author Fly.Hugh
 * @Date 2020/7/14 4:48 下午
 * @Version 1.0
 **/
public class Singleton3 {
    private static final Singleton3 INSTANCE = new Singleton3();
    private Singleton3() {}

    private static Singleton3 getInstance() {
        return INSTANCE;
    }
}
