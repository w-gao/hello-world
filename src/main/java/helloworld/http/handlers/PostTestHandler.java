package main.java.helloworld.http.handlers;

import main.java.helloworld.http.api.Request;
import main.java.helloworld.http.api.Response;
import main.java.helloworld.http.api.methods.PostHandler;

/**
 * hello-world
 *
 * @author w-gao Copyright (c) 2016
 * @version 1.0
 */
public class PostTestHandler extends PostHandler {

    @Override
    public void post(Request req, Response res) {

        System.out.println(req.getRequestBody("test"));
        System.out.println(req.getRequestBody("blah"));

        res.write("hia!");
    }
}
