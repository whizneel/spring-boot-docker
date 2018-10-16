package com.nilesh.controller;

import com.nilesh.requestBody.StatusRequestBody;
import com.nilesh.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StatusController {

    @Autowired
    private StatusService statusService;


    @PostMapping("/status")
    public Object getStatus(@RequestBody StatusRequestBody statusRequestBody)  {
        try {
            return statusService.getStatus(statusRequestBody);
        }
        catch (Exception e){
            return "Some error occurred" + e.getMessage() ;
        }


    }
}
