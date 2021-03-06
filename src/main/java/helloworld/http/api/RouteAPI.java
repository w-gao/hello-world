package main.java.helloworld.http.api;

import main.java.helloworld.http.Handler;
import main.java.helloworld.http.Request;
import main.java.helloworld.lang.Lang;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * hello-world
 *
 * @author w-gao Copyright (c) 2016
 * @version 1.0
 */
public class RouteAPI {

    private static Logger Log = LogManager.getLogger(RouteAPI.class);

    private static Map<String, Handler> getRoutes = new HashMap<>();

    private static Map<String, Handler> postRoutes = new HashMap<>();

    public static void get(final String key, final Handler handler) {
        getRoutes.put(key, handler);
    }

    public static void post(final String key, final Handler handler) {
        postRoutes.put(key, handler);
    }

    public static Handler get(String method, String key) {

        switch (method) {
            case Request.GET:
                return getRoutes.get(key);
            case Request.POST:
                return postRoutes.get(key);
            default:
                if(Log.isDebugEnabled()) Log.warn(Lang.get("HTTP_ROUTE_METHOD_NOT_FOUND", method));
                return null;
        }
    }
}
