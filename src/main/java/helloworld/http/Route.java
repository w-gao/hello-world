package main.java.helloworld.http;

import main.java.helloworld.http.handlers.HelloHandler;
import main.java.helloworld.http.handlers.PostTestHandler;
import main.java.helloworld.http.handlers.TestHandler;
import main.java.helloworld.lang.Lang;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static main.java.helloworld.http.api.RouteAPI.get;
import static main.java.helloworld.http.api.RouteAPI.post;

/**
 * hello-world
 *
 * @author w-gao Copyright (c) 2016
 * @version 1.0
 */
class Route {

    private static Logger Log = LogManager.getLogger(Route.class);

    Route() {

        try {
            // init
            get("/hello", new HelloHandler());
            get("/test", new TestHandler());

            post("/post", new PostTestHandler());
        } catch (Exception ex) {

            Log.error(Lang.get("GENERIC_ERROR_Ex", ex.getMessage()));
        }
    }

}