package main.java.helloworld.http.api;

import java.util.List;
import java.util.Objects;

/**
 * hello-world
 *
 * @author w-gao Copyright (c) 2016
 * @version 1.0
 */
public class AuthAPI {

    private static String _token;

    public static String getToken() {

        return _token;
    }

    public static void setToken(String token) {

        _token = token;
    }

    public static boolean verify(String token) {

        return token != null && Objects.equals(_token, token.trim());
    }
}
