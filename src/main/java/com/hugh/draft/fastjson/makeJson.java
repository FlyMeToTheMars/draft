package com.hugh.draft.fastjson;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author Fly.Hugh
 * @Date 2020/7/16 2:03 下午
 * @Version 1.0
 **/
public class makeJson {
    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("age", 30);
        jsonObject.put("name", "flyhugh");

        String jsonStr = jsonObject.toJSONString();
        System.out.println(jsonStr);

    }
}
