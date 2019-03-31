package xyz.randomwords.app.configuration;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.internal.LinkedTreeMap;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DixConfig {

    private HashMap<String, Object> config = new HashMap<>();

    public HashMap<String, Integer> alphaFrequency;

    public DixConfig() {

        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("src/main/resources/data.json"));
            Gson gson = new Gson();
            config = gson.fromJson(bufferedReader, HashMap.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Double markov(String k1, String k2) {
        if( k1 == null || k2 == null )
            return 0.0;
        return (Double) ((LinkedTreeMap) ((LinkedTreeMap) config.get("markov")).get(k1)).get(k2);
    }

    public Double maxMarkovComb() {
        return (Double) config.get("max_markov_comb");
    }

    public Double alphaFrequency(String k) {
        return (Double) ((LinkedTreeMap) config.get("alpha_freq")).get(k);
    }

    public Double dixLen() {
        return (Double) config.get("dix_len");
    }

    public Double position(String k1, String k2) {
        return (Double) ((LinkedTreeMap) ((LinkedTreeMap) config.get("position")).get(k1)).get(k2);
    }
}
