package main.java.helloworld.http.api;

/**
 * hello-world
 *
 * @author w-gao Copyright (c) 2016
 * @version 1.0
 */
public class Result {
    int code = 200;
    String message;
    static final long time = System.currentTimeMillis();

    public Result(String message) {
        this(200, message);
    }

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
