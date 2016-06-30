package main.java.helloworld.http.api;

/**
 * hello-world
 *
 * @author w-gao Copyright (c) 2016
 * @version 1.0
 */
public interface Response {

    void write(String result);

    void write(String result, int statusCode);
}