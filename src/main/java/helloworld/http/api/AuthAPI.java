package main.java.helloworld.http.api;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Objects;

/**
 * hello-world
 *
 * @author w-gao Copyright (c) 2016
 * @version 1.0
 */
public class AuthAPI {

    private static SecureRandom random = new SecureRandom();

    private static String _token;

    public static String getToken() {

        if(_token == null) generateToken();

        return _token;
    }

    private static void generateToken() {
        _token = new BigInteger(130, random).toString(32);
    }

    public static boolean verify(String token) {
        return Objects.equals(_token, token.trim());
    }
}
