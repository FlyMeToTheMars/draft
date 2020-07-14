package com.hugh.draft.singleton;

/**
 * @Author Fly.Hugh
 * @Date 2020/7/14 5:51 下午
 * @Version 1.0
 **/
public enum Singleton5 {
    INSTANCE;

    public void fun1() {
        System.out.println("hello singleton");
    }

    public static void main(String[] args) {
        Singleton5.INSTANCE.fun1();
    }

}
