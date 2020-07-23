package com.hugh.draft.ternaryoperator;

/**
 * @program: draft
 * @description:
 * @author: Fly.Hugh
 * @create: 2020-07-24 02:23
 **/
public class TernaryOperator {
    public static void main(String[] args) {
        int a = 1;
        Integer b = 2;
        boolean c = true;
        int d = c ? b : a;
        System.out.println(d);

        System.out.println("---------------------------");

        String str = "abc";
        StringBuilder strbu = new StringBuilder("def");
        boolean boo =true;
        CharSequence cs = boo ? str : strbu;
        System.out.println(cs);
    }
}
