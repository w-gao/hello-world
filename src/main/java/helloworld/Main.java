package main.java.helloworld;

import main.java.helloworld.http.HttpProvider;
import main.java.helloworld.http.Route;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

    private static Logger Log = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        Log.info("Hello World!");


        initHttpServer();
    }

    private static void initHttpServer() {

        Log.info("Starting http server...");

        HttpProvider provider = new HttpProvider(HTTP_PORT, HTTP_MAX_CONN);
        provider.startService();

        new Route();

        Log.info("Done.");

        Log.info("Press Enter to Stop...");

        // -----------------------------------------
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            br.readLine();
        } catch (Exception ex) {
            // ignored
        }
        // -----------------------------------------

        Log.info("Stopping http server...");
        provider.stopHttpServer();
    }
}
