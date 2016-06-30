package main.java.helloworld.http.api;

/**
 * hello-world
 *
 * @author w-gao Copyright (c) 2016
 * @version 1.0
 */

public abstract class HttpHandler implements Handler {

    @Override
    public void handle(Request request, Response response) {

        try {
            request.initHeader();
            request.initParam();

            if(request.getMethod().equals(Request.GET)) {
                get(request, response);
            } else {
                response.write("Invalid method: " + request.getMethod(), 201);
            }

        }catch (Exception ex){
            response.write("An error occurred:", 500);

            ex.printStackTrace();
        }
    }

    @Override
    public abstract void get(Request request, Response response);
}