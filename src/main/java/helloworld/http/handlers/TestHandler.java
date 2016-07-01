package main.java.helloworld.http.handlers;

import main.java.helloworld.http.Request;
import main.java.helloworld.http.Response;
import main.java.helloworld.http.api.Result;
import main.java.helloworld.http.impl.methods.GetHandler;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * hello-world
 *
 * @author w-gao Copyright (c) 2016
 * @version 1.0
 */
public class TestHandler extends GetHandler {

    private SecureRandom random = new SecureRandom();

    @Override
    public void get(Request request, Response response) {

        response.write(new Result(new BigInteger(130, random).toString(32)));
    }
}
