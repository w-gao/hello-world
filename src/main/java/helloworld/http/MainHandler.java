package main.java.helloworld.http;


import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import main.java.helloworld.http.api.*;

import java.io.IOException;

/**
 * hello-world
 *
 * Main Handler
 *
 * @author w-gao Copyright (c) 2016
 * @version 1.0
 */
class MainHandler implements HttpHandler {

    public void handle(HttpExchange httpExchange) throws IOException {
        String key = httpExchange.getRequestURI().getPath();

        if(key.equals("/favicon.ico")) return;      // todo

        System.out.println("Request: " + key + " - From: " + httpExchange.getRemoteAddress().getHostName());

        // TODO PERMISSIONS!!

        HttpRequest request = new HttpRequest(httpExchange);
        HttpResponse response = new HttpResponse(httpExchange);

        Handler handler = Route.get(key);

        if(handler == null){
            response.write("404 - Not found");
            return;
        }
        handler.handle(request, response);
    }
}
