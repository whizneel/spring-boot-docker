package com.nilesh.service;


import com.google.gson.Gson;
import com.nilesh.commonUtil.RestProcessorClient;
import com.nilesh.requestBody.StatusRequestBody;
import com.nilesh.responseBody.StatusProviderResponseBody;
import com.nilesh.responseBody.StatusResponseBody;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class StatusServiceTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @InjectMocks
    private StatusService statusService;


    @Mock
    private RestProcessorClient restProcessorClient;

    private StatusRequestBody statusRequestBody;

    @Before
    public void setUp() throws Exception {
        statusRequestBody = getRequestBody();
    }

    @After
    public void tearDown() throws Exception {
    }



    @Test
    public void getStatusWhenCorrectInformationSupplied() throws Exception {

        String url = "http://cricapi.com/api/cricketScore";
        Map<String, String> body = new LinkedHashMap<String, String>();
        body.put("unique_id", statusRequestBody.getUnique_id());
        StatusResponseBody responseBody = getresponseBody();
        body.put("apikey", statusRequestBody.getApikey());
        when((StatusResponseBody)restProcessorClient.process(any(), any(), any(), any(), any())).
                thenReturn(responseBody);

        StatusResponseBody expectedResponseBody = getresponseBody();

        StatusResponseBody actualResponseBody = statusService.getStatus(statusRequestBody);

//        assertEquals(expectedResponseBody.getCache(),actualResponseBody.getCache());
        System.out.println("nilesh");


    }

    private StatusRequestBody getRequestBody() {
        StatusRequestBody reBody = new StatusRequestBody();
        reBody.setUnique_id("1234");
        reBody.setApikey("jwcjbdwnwdnwn");
        return reBody;
    }

    private StatusResponseBody getresponseBody() {
        StatusResponseBody responseBody = new StatusResponseBody();
        StatusProviderResponseBody providerResponseBody = new StatusProviderResponseBody();
        responseBody.setCache("nilesh");
        responseBody.setScore("178");
        providerResponseBody.setSource("test");
        providerResponseBody.setUrl("http://payumoney.com");
        responseBody.setStatusProviderResponseBody(providerResponseBody);
        return responseBody;
    }


}