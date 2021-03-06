package main.java.helloworld.http.handlers;

import main.java.helloworld.http.Request;
import main.java.helloworld.http.Response;
import main.java.helloworld.http.api.Result;
import main.java.helloworld.http.impl.methods.GetHandler;

/**
 * hello-world
 *
 * @author w-gao Copyright (c) 2016
 * @version 1.0
 */
public class HelloHandler extends GetHandler {

    @Override
    public void get(Request request, Response response) {

        String name = "world";
        if (request.getParam("user") != null) {
            name = request.getParam("user");
        }
        response.write("Hello " + name + "!");
    }
}