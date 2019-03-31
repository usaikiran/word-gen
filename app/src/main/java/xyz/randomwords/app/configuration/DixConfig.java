package xyz.randomwords.app.configuration;

import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.FileReader;

public class DixConfig {

    static {

        BufferedReader bufferedReader = new BufferedReader( new FileReader( "" ) );

        Gson gson = new Gson();
        HashMap<String, String> json = gson.fromJson(bufferedReader, HashMap.class);

        private JsonObject config =
    }

    public static JsonObject read( String property ){

    }
}
