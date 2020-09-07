package com.hugh;

import com.hugh.pojo.Order;
import com.hugh.pojo.User;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Fly.Hugh
 * @Date 2020/9/7 12:18 下午
 * @Version 1.0
 **/
public class JavaExample {
    /**
     * 计算额外积分金额 规则如下: 订单原价金额
     * 100以下, 不加分
     * 100-500 加100分
     * 500-1000 加500分
     * 1000 以上 加1000分
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{

        List<Order> orderList = getInitData();
        for (Order order : orderList) {
            if (order.getAmout() <= 100) {
                order.setScore(0);
                addScore(order);
            } else if (order.getAmout() > 100 && order.getAmout() <= 500) {
                order.setScore(100);
                addScore(order);
            } else if (order.getAmout() > 500 && order.getAmout() <= 1000) {
                order.setScore(500);
                addScore(order);
            } else {
                order.setScore(1000);
                addScore(order);
            }
        }

    }

    private static void addScore(Order o){
        System.out.println("用户" + o.getUser().getName() + "享受额外增加积分: " + o.getScore());
    }

    private static List<Order> getInitData() throws Exception {
        List<Order> orderList = new ArrayList();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        {
            Order order = new Order();
            order.setAmout(80);
            order.setBookingDate(df.parse("2015-07-01"));
            User user = new User();
            user.setLevel(1);
            user.setName("Name1");
            order.setUser(user);
            orderList.add(order);
        }
        {
            Order order = new Order();
            order.setAmout(200);
            order.setBookingDate(df.parse("2015-07-02"));
            User user = new User();
            user.setLevel(2);
            user.setName("Name2");
            order.setUser(user);
            orderList.add(order);
        }
        {
            Order order = new Order();
            order.setAmout(800);
            order.setBookingDate(df.parse("2015-07-03"));
            User user = new User();
            user.setLevel(3);
            user.setName("Name3");
            order.setUser(user);
            orderList.add(order);
        }
        {
            Order order = new Order();
            order.setAmout(1500);
            order.setBookingDate(df.parse("2015-07-04"));
            User user = new User();
            user.setLevel(4);
            user.setName("Name4");
            order.setUser(user);
            orderList.add(order);
        }
        return orderList;
    }
}