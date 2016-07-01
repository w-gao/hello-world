package main.java.helloworld.http.api.methods;

import main.java.helloworld.http.api.Handler;
import main.java.helloworld.http.api.Request;
import main.java.helloworld.http.api.Response;

/**
 * hello-world
 *
 * @author w-gao Copyright (c) 2016
 * @version 1.0
 */
public abstract class PostHandler implements Handler {

    @Override
    public void handle(Request request, Response response) {

        try {
            request.initHeader();
            //  request.initParam();        // does post use params?

            request.initRequestBody();

            post(request, response);

        }catch (Exception ex){
            response.write("An error occurred", 500);

            ex.printStackTrace();
        }
    }

    protected abstract void post(Request req, Response res);
}