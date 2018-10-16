package com.nilesh.requestBody;


public class StatusRequestBody {

    public String getUnique_id() {
        return unique_id;
    }



    private String unique_id;

    public void setUnique_id(String unique_id) {
        this.unique_id = unique_id;
    }

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    private String apikey ;


}
