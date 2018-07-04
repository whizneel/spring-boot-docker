package com.kalpesh.service;
import com.google.gson.Gson;
import com.kalpesh.commonUtil.RestProcessorClient ;
import com.kalpesh.requestBody.StatusRequestBody;
import com.kalpesh.responseBody.StatusResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class StatusService {

    @Autowired
    private RestProcessorClient restProcessorClient ;


    public StatusResponseBody getStatus (StatusRequestBody statusRequestBody) throws Exception{
        String uniqueId = statusRequestBody.getUnique_id();
        String apiKey = statusRequestBody.getApikey();
        if (uniqueId == null){
            throw new Exception("null unique id is not acceptable");
        }
        else if (uniqueId.trim().equals("")){
            throw new Exception("empty unique id is not acceptable");
        }
        if (apiKey == null){
            throw new Exception("null api key is not acceptable");
        }
        if (apiKey.trim().equals("")){
            throw new Exception("empty api key is not acceptable");
        }
        try {
            Integer.parseInt(uniqueId);
            String finalUrl = "http://cricapi.com/api/cricketScore";
            Map<String,String> body = new LinkedHashMap<String, String>();
            body.put("unique_id",uniqueId);
            body.put("apiKey",apiKey);

            StatusResponseBody responseBody = (StatusResponseBody) restProcessorClient.process(finalUrl,null,new Gson().toJson(body),StatusResponseBody.class, HttpMethod.POST);
            return  responseBody;
        }
        catch (NumberFormatException e){
            throw new Exception("unique id must be numeric");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            throw new Exception(e.getMessage());

        }
    }

}
