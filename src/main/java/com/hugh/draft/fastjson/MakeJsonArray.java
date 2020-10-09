package com.hugh.draft.fastjson;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @program: draft
 * @description: jsonarray
 * @author: Fly.Hugh
 * @create: 2020-10-10 05:53
 **/
public class MakeJsonArray {
    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        JSONObject jsonObject1 = new JSONObject();

        JSONArray jsonArray = new JSONArray();
        jsonObject1.put("001", "tom");

        // JSONObject 对象中添加键值对
        jsonObject.put("key", "value");
        jsonObject.put("key1","value1");
        jsonArray.add(jsonObject);
        jsonArray.add(jsonObject1);

        System.out.println(jsonArray.toString());


    }
}
