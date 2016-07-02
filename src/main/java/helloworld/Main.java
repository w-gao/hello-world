package main.java.helloworld;


import main.java.helloworld.http.HttpServer;
import main.java.helloworld.lang.Lang;
import main.java.helloworld.utils.Config;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * hello-world
 *
 * @author w-gao Copyright (c) 2016
 * @version 1.0
 */
public class Main {

    private static Logger Log = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        new Lang();

        new Config();

        Log.info(Lang.get("HELLO_WORLD", 1.0));

        if(Config.getPropertyBoolean("EnableHttp", false)){

            int port = Config.getPropertyInt("HttpPort", 8080);
            int maxConn = Config.getPropertyInt("HttpMaxConn", 100);

            new HttpServer(port, maxConn);
        }
    }

}
