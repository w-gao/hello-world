package main.java.helloworld.http.api;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.OutputStream;

/**
 * hello-world
 *
 * @author w-gao Copyright (c) 2016
 * @version 1.0
 */
public class HttpResponse implements Response {

    private static Logger Log = LogManager.getLogger(HttpResponse.class);

    private HttpExchange httpExchange;

    public HttpResponse(HttpExchange httpExchange) {
        this.httpExchange = httpExchange;
    }

    @Override
    public void write(Result result) {
        Log.info("Return: '" + result.message + "'");

        Gson gson = new Gson();
        String json = gson.toJson(result);

        try {
            httpExchange.sendResponseHeaders(200, json.length());
            OutputStream out = httpExchange.getResponseBody();
            out.write(json.getBytes());
            out.flush();
            httpExchange.close();
        } catch (IOException e) {

            Log.error("An error occurred: " + e.getMessage());
            //e.printStackTrace();
        }
    }
}