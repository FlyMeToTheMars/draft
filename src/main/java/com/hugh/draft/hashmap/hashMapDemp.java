package com.hugh.draft.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: draft
 * @description: hashmap
 * @author: Fly.Hugh
 * @create: 2020-07-15 23:56
 **/
public class hashMapDemp {
    public static void main(String[] args){
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "a");
        map.put("4", "c");

        String s = map.get("1");
        System.out.println(s);
    }
}
