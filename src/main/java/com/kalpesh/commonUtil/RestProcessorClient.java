package com.kalpesh.commonUtil;


import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

@Component
public class RestProcessorClient<T,N>{


    public T process(String url, HttpHeaders headers, N param, Class<T> type, HttpMethod httpMethod)
            throws Exception {

        System.out.println("yo");
        T retObj = null;
        RestTemplate restTemplate = new RestTemplate();
        try {
            HttpEntity<N> httpEntity = new HttpEntity<N>(param, headers);

            ResponseEntity<T> responseEntity = restTemplate.exchange(url, httpMethod, httpEntity, type);

            if (HttpStatus.OK == responseEntity.getStatusCode()) {
                retObj = responseEntity.getBody();
                return retObj;
            }

        } catch (HttpStatusCodeException e) {

            String responseString = e.getResponseBodyAsString();
            Exception exception = null;

            if (!(StringUtils.isEmpty(responseString))) {
                try {
                    JSONObject json = new JSONObject(responseString);

                    exception = new Exception(json.toString());
                    throw exception;

                } catch (JSONException e1) {
                    System.out.println(e1);
                }
            } else {
                String error = e.getStatusText();
                String errorDescription = e.getMessage();

                if (StringUtils.isEmpty(error)) {
                    error = "error";
                }

                if (StringUtils.isEmpty(errorDescription)) {
                    errorDescription = "error in calling API url" + url;
                }

                exception = new Exception(errorDescription);
                throw exception;
            }

        }catch(Exception e){
            System.out.println(e);
        }
        finally {
            restTemplate = null;
        }

        return retObj;
    }

}