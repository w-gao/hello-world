package main.java.helloworld.http;

/**
 * hello-world
 *
 * @author w-gao Copyright (c) 2016
 * @version 1.0
 */
public interface Handler {

    void handle(Request request, Response response);
}
