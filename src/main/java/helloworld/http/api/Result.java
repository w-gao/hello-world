package main.java.helloworld.http.api;

/**
 * hello-world
 *
 * @author w-gao Copyright (c) 2016
 * @version 1.0
 */
public class Result {

    public int code = 200;
    public String message;
    public String extra;
    public long time = System.currentTimeMillis();

    public Result(String message) {
        this(200, message, "");
    }

    public Result(int code, String message) {
        this(code, message, "");
    }

    public Result(String message, String extra) {
        this(200, message, extra);
    }

    public Result(int code, String message, String extra) {
        this.code = code;
        this.message = message;
        this.extra = extra;
    }
}
