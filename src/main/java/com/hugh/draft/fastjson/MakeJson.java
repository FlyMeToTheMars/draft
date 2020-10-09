package com.hugh.draft.fastjson;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;

/**
 * @Author Fly.Hugh
 * @Date 2020/7/16 2:03 下午
 * @Version 1.0
 **/
public class MakeJson {
    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("imei", "123456789");
        jsonObject.put("modifiedDate", DateFormatUtils.format(new Date(), "yyyy-MM-dd hh:mm:ss"));
        jsonObject.put("status",false);
        jsonObject.put("saveDays",3);
        jsonObject.put("dateBeginStr","2020-8-1 00:00:00");


        String jsonStr = jsonObject.toJSONString();
        System.out.println(jsonStr);

    }
}
