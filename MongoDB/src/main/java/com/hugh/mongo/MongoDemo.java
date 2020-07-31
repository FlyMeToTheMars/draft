package com.hugh.mongo;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import org.bson.Document;

import java.util.*;
import java.util.regex.Pattern;

/**
 * @Author Fly.Hugh
 * @Date 2020/7/29 9:05 上午
 * @Version 1.0
 **/
public class MongoDemo {
    public static void main(String[] args) {
        BasicDBObject query = new BasicDBObject();
        query.put("id", 123);

        Pattern allFullId = Pattern.compile("^"+"123456789"+".*$", Pattern.CASE_INSENSITIVE);
        query.put("allFullID",allFullId);

        System.out.println("----------------修改后----------------");
        query.put("id",234);

        List<Document> list = new ArrayList<Document>();
        list.add(new Document("speed", BasicDBObjectBuilder.start("$lte", 5).get()));
        list.add(new Document("stopTime",BasicDBObjectBuilder.start("$lte", new Date(new Date().getTime()-480000)).get()));
        query.put("$or",list);

        String s = query.toJson();
        System.out.println(s);

        HashSet<String> hs = new HashSet();

        hs.add("10256");
        hs.add("GT740");
        System.out.println(hs.contains("10256"));

        HashMap<String, List<String>> hm = new HashMap<>();
        List<String> ls_10256 = Arrays.asList("GT740","GT770");
        hm.put("10256",ls_10256);

        boolean contains = hm.keySet().contains("10256");
        System.out.println(contains);

        boolean gt740 = hm.get("10256").contains("GT740");
        System.out.println(gt740);


    }
}