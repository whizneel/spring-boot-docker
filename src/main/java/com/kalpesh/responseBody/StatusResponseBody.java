package com.kalpesh.responseBody;

public class StatusResponseBody {

    private String cache ;

    private String score ;

    public String getCache() {
        return cache;
    }

    public void setCache(String cache) {
        this.cache = cache;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public StatusProviderResponseBody getStatusProviderResponseBody() {
        return statusProviderResponseBody;
    }

    public void setStatusProviderResponseBody(StatusProviderResponseBody statusProviderResponseBody) {
        this.statusProviderResponseBody = statusProviderResponseBody;
    }

    private StatusProviderResponseBody statusProviderResponseBody ;



}
