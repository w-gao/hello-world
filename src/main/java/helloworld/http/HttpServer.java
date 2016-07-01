package main.java.helloworld.http;

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
public class HttpServer {

    private static Logger Log = LogManager.getLogger(HttpServer.class);

    public HttpServer(int port, int maxConn){

        Log.info(Lang.get("HTTP_SRV_STARTING"));

        HttpProvider provider = new HttpProvider(port, maxConn);
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
