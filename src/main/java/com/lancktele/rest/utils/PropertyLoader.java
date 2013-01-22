package com.lancktele.rest.utils;

import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * User: azee
 */

@Service
public class PropertyLoader {
    public String getEndpoint(){
        if (System.getProperty("custom.endpoint") == null){
            return "dev0.etservice.net/ais/api/1.0";
        }
        else return System.getProperty("custom.endpoint");
    }
}
