package main.java.helloworld.http.handlers;

import main.java.helloworld.http.api.*;

/**
 * hello-world
 *
 * @author w-gao Copyright (c) 2016
 * @version 1.0
 */
public class HelloHandler extends HttpHandler {

    @Override
    public void get(Request request, Response response) {

        response.write("Hello world!");
    }
}