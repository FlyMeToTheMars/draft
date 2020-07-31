package com.hugh.draft.time;

import java.util.Date;

/**
 * @Author Fly.Hugh
 * @Date 2020/7/30 3:08 下午
 * @Version 1.0
 **/
public class BeforeDemo {
    public static void main(String[] args) {
        Date d1 = new Date();
        System.out.println(d1);

        Date d2 = new Date(new Date().getTime() - 2300);

        boolean flag = d2.before(d1);
        System.out.println(flag);
    }
}
