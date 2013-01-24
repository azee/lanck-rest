package com.lancktele.rest.utils;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * User: azee
 */

@Service
public class Parser {

    public <T>T unmarshal(String response, String rootName, Class<T> objectClass) throws Exception{
        if (rootName != null && !"".equals(rootName)){
            response = "{\"" + rootName + "\": " + response + "}";
        }
        ObjectMapper mapper = new ObjectMapper();
        return (T)mapper.readValue(response, objectClass);

    }
}
