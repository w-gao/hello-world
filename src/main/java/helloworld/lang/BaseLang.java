package main.java.helloworld.lang;

import java.util.HashMap;
import java.util.Map;

/**
 * hello-world
 *
 * @author w-gao Copyright (c) 2016
 * @version 1.0
 */
public class BaseLang {

    private static Map<String, String> langs = new HashMap<>();

    // todo load from files?
    public BaseLang(){
        langs.put("WELCOME_MSG", "Hello World!");

    }

    public static String get(String key){
        return langs.get(key);
    }
}
