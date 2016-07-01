package main.java.helloworld.http;

import main.java.helloworld.http.api.Result;

/**
 * hello-world
 *
 * @author w-gao Copyright (c) 2016
 * @version 1.0
 */
public interface Response {

    void write(Result result);
}