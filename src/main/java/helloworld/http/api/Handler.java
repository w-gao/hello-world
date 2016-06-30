package main.java.helloworld.http.api;

/**
 * hello-world
 *
 * @author w-gao Copyright (c) 2016
 * @version 1.0
 */
public interface Handler {

    void handle(Request request, Response response);

    void get(Request req, Response res);

    // todo more methods!
}
