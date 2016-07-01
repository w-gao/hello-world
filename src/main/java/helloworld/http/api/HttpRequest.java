package main.java.helloworld.http.api;

import com.sun.net.httpserver.HttpExchange;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * hello-world
 *
 * @author w-gao Copyright (c) 2016
 * @version 1.0
 */
public class HttpRequest implements Request {

    private static Logger Log = LogManager.getLogger(HttpRequest.class);

    private HttpExchange httpExchange;

    private Map<String, String> params = new HashMap<>();

    private Map<String, List<String>> headers = new HashMap<>();

    private Map<String, String> requestBody = new HashMap<>();

    public HttpRequest(HttpExchange httpExchange) {
        this.httpExchange = httpExchange;
    }

    @Override
    public URI getRequestURI() {
        return httpExchange.getRequestURI();
    }

    @Override
    public String getMethod() {
        return httpExchange.getRequestMethod().trim().toUpperCase();
    }

    @Override
    public void initHeader() {

        for(String s : httpExchange.getRequestHeaders().keySet()){
            headers.put(s, httpExchange.getRequestHeaders().get(s));
        }
    }

    @Override
    public List<String> getHeader(String key){

        return headers.get(key);
    }

    @Override
    public void initParam() {
        String query = getRequestURI().getQuery();

        if(query == null){
            Log.warn("Param is null");
            return;
        }

        params = parseParams(query);
    }

    @Override
    public String getParam(String param) {
        return params.get(param);
    }

    @Override
    public void initRequestBody() {

        InputStreamReader isr;
        try {
            isr = new InputStreamReader(httpExchange.getRequestBody());
            BufferedReader br = new BufferedReader(isr);
            String value = br.readLine();

            if(value == null){
                Log.warn("Body is null");
                return;
            }

            requestBody = parseParams(value);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String getRequestBody(String key) {
        return requestBody.get(key);
    }

    private Map<String, String> parseParams(String par){

        String [] arrayStr = par.split("&");

        Map<String, String> map = new HashMap<>();

        for(String str : arrayStr){

            if(str.split("=").length != 2){

                Log.warn("Missing Data from client!!!");
                continue;
            }
            String key = str.split("=")[0];
            String value = str.split("=")[1];

            map.put(key, value);
            //Log.info(key + ": " + value);
        }
        return map;
    }
}