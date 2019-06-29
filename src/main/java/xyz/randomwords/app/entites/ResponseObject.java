package xyz.randomwords.app.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude
public class ResponseObject {

    String word;
    @JsonIgnore
    double responseTime;
    double confidence;

    public ResponseObject( String word, double responseTime, double confidence ){

        this.word = word;
        this.responseTime = responseTime;
        setConfidence( confidence );
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public double getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(double responseTime) {
        this.responseTime = responseTime;
    }

    public double getConfidence() {
        return confidence;
    }

    public void setConfidence(double confidence) {
        this.confidence = confidence>1 ? 1 : confidence;
    }

    @Override
    public String toString() {
        return "{" +
                "word='" + word + '\'' +
                ", confidence=" + confidence +
                '}';
    }
}
