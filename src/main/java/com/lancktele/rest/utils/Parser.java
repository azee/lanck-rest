package com.lancktele.rest.utils;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.xc.JaxbAnnotationIntrospector;
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
        AnnotationIntrospector introspector = new JaxbAnnotationIntrospector();
        mapper.getDeserializationConfig().setAnnotationIntrospector(introspector);
        return (T)mapper.readValue(response, objectClass);
    }

//    public <T> String marshal(T object, String rootName) throws Exception{
//        String result;
//        if (rootName != null && !"".equals(rootName)){
//            //response = "{\"" + rootName + "\": " + response + "}";
//        }
//        ObjectMapper mapper = new ObjectMapper();
//        AnnotationIntrospector introspector = new JaxbAnnotationIntrospector();
//        mapper.getSerializationConfig().setAnnotationIntrospector(introspector);
//        //mapper.configure(JsonGenerator.Feature.QUOTE_FIELD_NAMES, false);
//        result = mapper.writeValueAsString(object);
//        //result = rootName + "=" + result;
//        return result;
//    }
}
