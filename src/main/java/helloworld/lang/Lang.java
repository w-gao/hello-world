package main.java.helloworld.lang;

import main.java.helloworld.utils.FileUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * hello-world
 *
 * @author w-gao Copyright (c) 2016
 * @version 1.0
 */
public class Lang {

    private static Logger Log = LogManager.getLogger(Lang.class);

    private static final String LANG_PATH = "lang/en.ini";

    private static Map<String, String> languages = new HashMap<>();

    public Lang() {

        //Log.debug("Loading Language from: " + LANG_PATH + "...");
        InputStream stream = this.getClass().getClassLoader().getResourceAsStream(LANG_PATH);

        try {
            String content = FileUtil.readFile(stream);
            Map<String, String> lang = new HashMap<>();

            // for debug
            if(!content.startsWith("# DO NOT REMOVE THIS LINE")) {
                Log.warn("Not valid language file.");
                return;
            }

            for (String line : content.split("\n")) {
                line = line.trim();
                if (line.equals("") || line.charAt(0) == '#') {
                    continue;
                }
                String[] t = line.split("=");
                if (t.length < 2) {
                    continue;
                }
                String key = t[0];
                String value = "";
                for (int i = 1; i < t.length - 1; i++) {
                    value += t[i] + "=";
                }
                value += t[t.length - 1];
                if (value.equals("")) {
                    continue;
                }
                lang.put(key, value);
            }
            languages = lang;

        } catch (IOException e) {
            Log.warn("Error while loading language: " + e.getMessage());
        }
    }

    public static String get(String key) {

        if (languages.containsKey(key)){
            return languages.get(key);
        } else {
            return key;
        }
    }

    public static String get(String key, Object...args){

        if (languages.containsKey(key)){
            return String.format(languages.get(key), args);
        } else {
            return key;
        }
    }
}
