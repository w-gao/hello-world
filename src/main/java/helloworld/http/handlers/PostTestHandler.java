package main.java.helloworld.http.handlers;

import main.java.helloworld.http.Request;
import main.java.helloworld.http.Response;
import main.java.helloworld.http.api.Result;
import main.java.helloworld.http.impl.methods.PostHandler;
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

        if(Log.isDebugEnabled()) Log.debug(req.getHeader("Accept-Language"));
        if(Log.isDebugEnabled()) Log.debug(req.getRequestBody("blah"));

        res.write(new Result("hia! - " + req.getHeader("Authorization")));
    }
}