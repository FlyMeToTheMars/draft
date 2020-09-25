package com.hugh.draft.jackson;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Author Fly.Hugh
 * @Date 2020/9/25 5:48 下午
 * @Version 1.0
 **/
public class Person {
    private String name;
    private Integer age;

    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    private Date time;

    public Person(String name, Integer age,Date time) {
        this.name = name;
        this.age = age;
        this.time = time;
    }
}
