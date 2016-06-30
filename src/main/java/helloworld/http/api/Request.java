package main.java.helloworld.http.api;

import java.net.URI;
import java.util.List;

/**
 * hello-world
 *
 * @author w-gao Copyright (c) 2016
 * @version 1.0
 */
public interface Request {

    String GET = "GET";
    //String POST = "POST"; // todo

    URI getRequestURI();

    String getMethod();


    void initHeader();

    List<String> getHeader(String key);

    void initParam();

    String getParam(String param);

    void initRequestBody();

    String getRequestBody();


}