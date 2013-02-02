package com.lancktele.rest.utils;

import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;

/**
 * Created by IntelliJ IDEA.
 * User: azee
 * Date: 2/2/13
 * Time: 8:11 PM
 */
@Service
public class NetService {
   @Autowired
   Parser parser;


    public HttpResponse doPostRequest(String url, String paramName, Object entity, String objectRootName) throws Exception, HttpException, URISyntaxException {
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost request = new HttpPost(url);

        //Marshall an object
        String marshalledObject = parser.marshal(entity, objectRootName);
        StringEntity params = new StringEntity(paramName + "=" + marshalledObject);
        request.addHeader("content-type", "application/x-www-form-urlencoded");
        request.setEntity(params);
        HttpResponse response = httpClient.execute(request);
        return response;
    }

    public HttpResponse doPutRequest(String url, String paramName, Object entity, String objectRootName) throws Exception, HttpException, URISyntaxException {
        HttpClient httpClient = new DefaultHttpClient();
        HttpPut request = new HttpPut(url);

        //Marshall an object
        String marshalledObject = parser.marshal(entity, objectRootName);
        StringEntity params = new StringEntity(paramName + "=" + marshalledObject);
        request.addHeader("content-type", "application/x-www-form-urlencoded");
        request.setEntity(params);
        HttpResponse response = httpClient.execute(request);
        return response;
    }
}
