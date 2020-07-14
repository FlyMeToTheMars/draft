package com.hugh.draft.singleton;

/**
 * @Author Fly.Hugh
 * @Date 2020/7/14 5:06 下午
 * @Version 1.0
 **/
public class Singleton4 {
    private static class SingletonHolder{
        private static final Singleton4 Instance = new Singleton4();
    }

    private Singleton4() {
    }

    public static final Singleton4 getInstace (){
        return SingletonHolder.Instance;
    }
}