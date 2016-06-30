package main.java.helloworld.http;

import main.java.helloworld.http.api.HttpHandler;
import main.java.helloworld.http.handlers.HelloHandler;
import main.java.helloworld.http.handlers.TestHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * hello-world
 *
 * @author w-gao Copyright (c) 2016
 * @version 1.0
 */
public class Route {

    private static Map<String, HttpHandler> routes = new HashMap<>();

    public Route() {
        // init
        add("/hello", new HelloHandler());
        add("/test", new TestHandler());
    }

    private void add(String key, HttpHandler handler){
        routes.put(key, handler);
    }

    static HttpHandler get(String key) {
        return routes.get(key);
    }


}