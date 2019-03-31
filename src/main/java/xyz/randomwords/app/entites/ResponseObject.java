package xyz.randomwords.app.entites;

public class ResponseObject {

    String word;
    double responseTime;
    double confidence;

    public ResponseObject( String word, double responseTime, double confidence ){

        this.word = word;
        this.responseTime = responseTime;
        this.confidence = confidence;
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
        this.confidence = confidence;
    }

    @Override
    public String toString() {
        return "{" +
                "word='" + word + '\'' +
                ", responseTime=" + responseTime +
                ", confidence=" + confidence +
                '}';
    }
}
