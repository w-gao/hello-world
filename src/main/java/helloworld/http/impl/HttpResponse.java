package main.java.helloworld.http.impl;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import main.java.helloworld.http.Response;
import main.java.helloworld.http.api.Result;
import main.java.helloworld.lang.Lang;
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
class HttpResponse implements Response {

    private static Logger Log = LogManager.getLogger(HttpResponse.class);

    private HttpExchange httpExchange;

    HttpResponse(HttpExchange httpExchange) {
        this.httpExchange = httpExchange;
    }

    @Override
    public void write(Result result) {

        Gson gson = new Gson();
        String json = gson.toJson(result);

        write(result.getCode(), json);
    }

    @Override
    public void write(String result){
        write(200, result);
    }

    @Override
    public void write(int code, String result){

        if(Log.isDebugEnabled()) Log.debug(Lang.get("HTTP_SRV_RETURNED", result));

        try {
            httpExchange.sendResponseHeaders(code, result.length());
            OutputStream out = httpExchange.getResponseBody();
            out.write(result.getBytes());
            out.flush();
            httpExchange.close();
        } catch (IOException e) {

            Log.error(Lang.get("GENERIC_ERROR_OCCURRED") + ": " + e.getMessage());
            //e.printStackTrace();
        }
    }
}