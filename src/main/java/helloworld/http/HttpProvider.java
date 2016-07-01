package main.java.helloworld.http;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.spi.HttpServerProvider;
import main.java.helloworld.lang.Lang;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.InetSocketAddress;

/**
 * hello-world
 *
 * @author w-gao Copyright (c) 2016
 * @version 1.0
 */
public class HttpProvider {

    private static Logger Log = LogManager.getLogger(HttpProvider.class);

    private int _port;
    private int _maxConn;

    private HttpServer httpServer;

    public HttpProvider(int port, int maxConn) {
        _port = port;
        _maxConn = maxConn;
    }

    public void startService() {
        Log.debug(Lang.get("HTTP_SRV_PORT", _port));

        try {
            HttpServerProvider provider = HttpServerProvider.provider();
            this.httpServer = provider.createHttpServer(new InetSocketAddress(_port), _maxConn);
            this.httpServer.createContext("/", new MainHandler());
            this.httpServer.setExecutor(null);
            this.httpServer.start();
        } catch (Exception ex) {
            Log.error(Lang.get("GENERIC_ERROR_MSG", "Perhaps you are using that port?"));
            System.exit(-1);
        }
    }

    public void stopHttpServer() {
        if (this.httpServer != null) {
            this.httpServer.stop(0);
        }
    }
}
