package com.hugh.draft.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author Fly.Hugh
 * @Date 2020/9/19 2:47 下午
 * @Version 1.0
 **/
public class RegexDemo {
    public static void main(String[] args) {
        demo2();
    }

    // ax^2+bx+c
    public static void demo2() {
        String reg = "(\\d{1,3})x\\^2([\\+|-])(\\d{1,3})x?([\\+|-])?(\\d{1,3})?";
        String test = "100x^2-2";
        Pattern pattern = Pattern.compile(reg);
        Matcher mc = pattern.matcher(test);
        if (mc.find()) {
            System.out.println("分组的个数有："+mc.groupCount());
            for (int i = 0; i <= mc.groupCount(); i++) {
                System.out.println("第" + i + "个分组为：" + mc.group(i));
            }
        }
    }

    public static void demo1() {
        String reg = "\\d+(?=</span>)";
        String test = "<span class=\"read-count\">阅读数：641</span>";
        Pattern pattern = Pattern.compile(reg);
        Matcher mc = pattern.matcher(test);
        while (mc.find()) {
            System.out.println(mc.group());
        }
    }

}