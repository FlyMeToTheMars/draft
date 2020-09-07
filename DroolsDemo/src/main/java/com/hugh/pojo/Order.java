package com.hugh.pojo;

import java.util.Date;


/**
 * @Author Fly.Hugh
 * @Date 2020/9/7 12:12 下午
 * @Version 1.0
 **/


public class Order {

    private Date bookingDate;//下单日期

    private int amout;//订单原价金额

    private User user;//下单人

    private int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public int getAmout() {
        return amout;
    }

    public void setAmout(int amout) {
        this.amout = amout;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }





}
