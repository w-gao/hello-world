package main.java.helloworld.http.impl.methods;

import main.java.helloworld.http.Handler;
import main.java.helloworld.http.Request;
import main.java.helloworld.http.Response;
import main.java.helloworld.http.api.AuthAPI;
import main.java.helloworld.http.api.Result;
import main.java.helloworld.lang.Lang;

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
            response.write(new Result(500, Lang.get("GENERIC_ERROR_OCCURRED")));

            ex.printStackTrace();
        }
    }

    protected boolean verify(Request request) {
        return AuthAPI.verify(request.getParam("key"));
    }

    protected abstract void get(Request req, Response res);
}
