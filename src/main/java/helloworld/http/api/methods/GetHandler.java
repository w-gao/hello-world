package main.java.helloworld.http.api.methods;

import main.java.helloworld.http.api.Handler;
import main.java.helloworld.http.api.Request;
import main.java.helloworld.http.api.Response;
import main.java.helloworld.http.api.Result;

/**
 * hello-world
 *
 * @author w-gao Copyright (c) 2016
 * @version 1.0
 */
public abstract class GetHandler implements Handler {

    @Override
    public void handle(Request request, Response response) {

        try {
            request.initHeader();
            request.initParam();

            get(request, response);

        } catch (Exception ex) {
            response.write(new Result(500, "An error occurred"));

            ex.printStackTrace();
        }
    }

    protected abstract void get(Request req, Response res);
}
