package main.java.helloworld.http.impl.methods;

import main.java.helloworld.http.Handler;
import main.java.helloworld.http.Request;
import main.java.helloworld.http.Response;
import main.java.helloworld.http.api.AuthAPI;
import main.java.helloworld.http.api.Result;
import main.java.helloworld.lang.Lang;
import main.java.helloworld.utils.Config;

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

        } catch (Exception ex) {
            response.write(new Result(500, Lang.get("GENERIC_ERROR_OCCURRED")));

            ex.printStackTrace();
        }
    }

    protected boolean verify(Request request) {
        return !Config.getPropertyBoolean("HttpEnableSecurity", false) || AuthAPI.verify(request.getHeader("Auth_key").get(0));

    }

    protected abstract void post(Request req, Response res);
}
