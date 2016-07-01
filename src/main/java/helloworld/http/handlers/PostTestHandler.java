package main.java.helloworld.http.handlers;

import main.java.helloworld.http.api.Request;
import main.java.helloworld.http.api.Response;
import main.java.helloworld.http.api.Result;
import main.java.helloworld.http.api.methods.PostHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * hello-world
 *
 * @author w-gao Copyright (c) 2016
 * @version 1.0
 */
public class PostTestHandler extends PostHandler {

    private static Logger Log = LogManager.getLogger(PostTestHandler.class);

    @Override
    public void post(Request req, Response res) {

        Log.debug(req.getRequestBody("test"));
        Log.debug(req.getRequestBody("blah"));

        res.write(new Result("hia!"));
    }
}
