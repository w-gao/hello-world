package main.java.helloworld.http.api;

import com.sun.net.httpserver.HttpExchange;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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

    private HttpExchange httpExchange;

    private Map<String, String> params = new HashMap<>();

    private Map<String, List<String>> headers = new HashMap<>();

    private String requestBody = "";

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
            System.out.println("Param is null");
            return;
        }

        String [] arrayStr = query.split("&");
        for(String str : arrayStr){
            params.put(str.split("=")[0], str.split("=")[1]);
        }
    }

    @Override
    public String getParam(String param) {
        return params.get(param);
    }

    // --- TODO post
    @Override
    public void initRequestBody() {
        InputStream in = httpExchange.getRequestBody();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String temp;
        try {
            while ((temp = reader.readLine()) != null) {
                requestBody += temp;
            }
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    @Override
    public String getRequestBody() {
        return requestBody;
    }
}