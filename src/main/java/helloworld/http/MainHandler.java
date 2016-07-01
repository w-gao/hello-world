package main.java.helloworld.http;


import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import main.java.helloworld.http.api.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

/**
 * hello-world
 * <p>
 * Main Handler
 *
 * @author w-gao Copyright (c) 2016
 * @version 1.0
 */
class MainHandler implements HttpHandler {

    private static Logger Log = LogManager.getLogger(MainHandler.class);

    public void handle(HttpExchange httpExchange) throws IOException {
        String key = httpExchange.getRequestURI().getPath();

        if (key.equals("/favicon.ico")) return;      // todo

        Log.info("Request: " + key + " - From: " + httpExchange.getRemoteAddress().getHostName());

        // TODO PERMISSIONS!!

        HttpRequest request = new HttpRequest(httpExchange);
        HttpResponse response = new HttpResponse(httpExchange);

        Handler handler = RouteAPI.get(request.getMethod(), key);

        Log.info(request.getMethod());

        if (handler == null) {
            response.write(new Result(404, "Not found"));
            return;
        }
        handler.handle(request, response);
    }
}
