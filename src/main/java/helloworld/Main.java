package main.java.helloworld;

import main.java.helloworld.http.HttpProvider;
import main.java.helloworld.http.Route;
import main.java.helloworld.lang.Lang;
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

        new Lang();

        Log.info(Lang.get("HELLO_WORLD", 1.0));

        initHttpServer();
    }

    private static void initHttpServer() {

        Log.info(Lang.get("HTTP_SRV_STARTING"));

        HttpProvider provider = new HttpProvider(HTTP_PORT, HTTP_MAX_CONN);
        provider.startService();

        new Route();

        Log.info(Lang.get("HTTP_SRV_STARTED"));

        Log.info(Lang.get("HTTP_STOP_NOTICE"));

        // -----------------------------------------
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            br.readLine();
        } catch (Exception ex) {
            // ignored
        }
        // -----------------------------------------

        Log.info(Lang.get("HTTP_SRV_STOPPING"));
        provider.stopHttpServer();
    }
}
