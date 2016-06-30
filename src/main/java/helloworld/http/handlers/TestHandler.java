package main.java.helloworld.http.handlers;

import main.java.helloworld.http.api.HttpHandler;
import main.java.helloworld.http.api.Request;
import main.java.helloworld.http.api.Response;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * hello-world
 *
 * @author w-gao Copyright (c) 2016
 * @version 1.0
 */
public class TestHandler extends HttpHandler {

    private SecureRandom random = new SecureRandom();

    @Override
    public void get(Request request, Response response) {

        response.write(new BigInteger(130, random).toString(32));
    }
}
