package main.java.helloworld.http.api;

import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.io.OutputStream;

/**
 * hello-world
 *
 * @author w-gao Copyright (c) 2016
 * @version 1.0
 */
public class HttpResponse implements Response {

    private HttpExchange httpExchange;

    public HttpResponse(HttpExchange httpExchange){
        this.httpExchange = httpExchange;
    }

    @Override
    public void write(String result){
        write(result, 200);
    }

    @Override
    public void write(String result, int statusCode) {
        System.out.println("Return: '" + result + "'");

        try {
            httpExchange.sendResponseHeaders(200, result.length());
            OutputStream out = httpExchange.getResponseBody();
            out.write(result.getBytes());
            out.flush();
            httpExchange.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
            //e.printStackTrace();
        }
    }
}