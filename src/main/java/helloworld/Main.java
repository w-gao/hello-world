package main.java.helloworld;

import main.java.helloworld.http.HttpProvider;
import main.java.helloworld.http.Route;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * hello-world
 *
 * @author w-gao Copyright (c) 2016
 * @version 1.0
 */
public class Main {

    private static final int HTTP_PORT = 8080;
    private static final int HTTP_MAX_CONN = 100;

    public static void main(String[] args) {

        System.out.println("Hello World!");

        initHttpServer();
    }

    private static void initHttpServer() {

        System.out.println("Starting http server...");

        HttpProvider provider = new HttpProvider(HTTP_PORT, HTTP_MAX_CONN);
        provider.startService();

        new Route();

        System.out.println("Done.");

        System.out.println("Press Enter to Stop...");

        // -----------------------------------------
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s = br.readLine();
        } catch (Exception ex) {
            // ignored
        }
        // -----------------------------------------

        System.out.println("Stopping http server...");
        provider.stopHttpServer();
    }
}
