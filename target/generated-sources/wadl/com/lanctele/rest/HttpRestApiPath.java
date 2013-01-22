
package com.lanctele.rest;

import java.util.HashMap;
import javax.annotation.Generated;
import javax.ws.rs.core.UriBuilder;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;


/**
 * 
 */
@Generated(value = "file:/home/azee/IdeaProjects/lanc/rest/src/main/resources/application.wadl", comments = "wadl2java")
public class HttpRestApiPath {


    public static class Service2 {

        private Client _client;
        private UriBuilder _uriBuilder;
        private HashMap<String, Object> _templateAndMatrixParameterValues;

        /**
         * Create new instance using existing Client instance
         * 
         */
        public Service2(Client client, String restApiPath) {
            _client = client;
            _uriBuilder = UriBuilder.fromPath("http://{rest.api.path}");
            _uriBuilder = _uriBuilder.path("/service2");
            _templateAndMatrixParameterValues = new HashMap<String, Object>();
            _templateAndMatrixParameterValues.put("rest.api.path", restApiPath);
        }

        /**
         * Create new instance
         * 
         */
        public Service2(String restApiPath) {
            this(Client.create(), restApiPath);
        }

        /**
         * Get rest.api.path
         * 
         */
        public String getRestApiPath() {
            return ((String) _templateAndMatrixParameterValues.get("rest.api.path"));
        }

        /**
         * Set rest.api.path
         * 
         */
        public HttpRestApiPath.Service2 setRestApiPath(String restApiPath) {
            _templateAndMatrixParameterValues.put("rest.api.path", restApiPath);
            return this;
        }

        public static class SomePathParamName {

            private Client _client;
            private UriBuilder _uriBuilder;
            private HashMap<String, Object> _templateAndMatrixParameterValues;

            /**
             * Create new instance using existing Client instance
             * 
             */
            public SomePathParamName(Client client, String restApiPath, String paramname) {
                _client = client;
                _uriBuilder = UriBuilder.fromPath("http://{rest.api.path}");
                _uriBuilder = _uriBuilder.path("/service2");
                _uriBuilder = _uriBuilder.path("/some/path/{paramName}");
                _templateAndMatrixParameterValues = new HashMap<String, Object>();
                _templateAndMatrixParameterValues.put("rest.api.path", restApiPath);
                _templateAndMatrixParameterValues.put("paramName", paramname);
            }

            /**
             * Create new instance
             * 
             */
            public SomePathParamName(String restApiPath, String paramname) {
                this(Client.create(), restApiPath, paramname);
            }

            /**
             * Get rest.api.path
             * 
             */
            public String getRestApiPath() {
                return ((String) _templateAndMatrixParameterValues.get("rest.api.path"));
            }

            /**
             * Set rest.api.path
             * 
             */
            public HttpRestApiPath.Service2 .SomePathParamName setRestApiPath(String restApiPath) {
                _templateAndMatrixParameterValues.put("rest.api.path", restApiPath);
                return this;
            }

            /**
             * Get paramName
             * 
             */
            public String getParamname() {
                return ((String) _templateAndMatrixParameterValues.get("paramName"));
            }

            /**
             * Set paramName
             * 
             */
            public HttpRestApiPath.Service2 .SomePathParamName setParamname(String paramname) {
                _templateAndMatrixParameterValues.put("paramName", paramname);
                return this;
            }

            public SomeBean getSomeBeanAsApplicationJson() {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                return resourceBuilder.method("GET", SomeBean.class);
            }

            public<T >T getAsApplicationJson(GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                return resourceBuilder.method("GET", returnType);
            }

            public<T >T getAsApplicationJson(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                return resourceBuilder.method("GET", returnType);
            }

            public SomeBean getSomeBeanAsApplicationJson(String cookie) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.header("Cookie", cookie);
                resourceBuilder = resourceBuilder.accept("application/json");
                return resourceBuilder.method("GET", SomeBean.class);
            }

            public<T >T getAsApplicationJson(String cookie, GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.header("Cookie", cookie);
                resourceBuilder = resourceBuilder.accept("application/json");
                return resourceBuilder.method("GET", returnType);
            }

            public<T >T getAsApplicationJson(String cookie, Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.header("Cookie", cookie);
                resourceBuilder = resourceBuilder.accept("application/json");
                return resourceBuilder.method("GET", returnType);
            }

            public SomeBean getSomeBeanAsApplicationXml() {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/xml");
                return resourceBuilder.method("GET", SomeBean.class);
            }

            public<T >T getAsApplicationXml(GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/xml");
                return resourceBuilder.method("GET", returnType);
            }

            public<T >T getAsApplicationXml(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/xml");
                return resourceBuilder.method("GET", returnType);
            }

            public SomeBean getSomeBeanAsApplicationXml(String cookie) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.header("Cookie", cookie);
                resourceBuilder = resourceBuilder.accept("application/xml");
                return resourceBuilder.method("GET", SomeBean.class);
            }

            public<T >T getAsApplicationXml(String cookie, GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.header("Cookie", cookie);
                resourceBuilder = resourceBuilder.accept("application/xml");
                return resourceBuilder.method("GET", returnType);
            }

            public<T >T getAsApplicationXml(String cookie, Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.header("Cookie", cookie);
                resourceBuilder = resourceBuilder.accept("application/xml");
                return resourceBuilder.method("GET", returnType);
            }

        }

    }

    public static class Users {

        private Client _client;
        private UriBuilder _uriBuilder;
        private HashMap<String, Object> _templateAndMatrixParameterValues;

        /**
         * Create new instance using existing Client instance
         * 
         */
        public Users(Client client, String restApiPath) {
            _client = client;
            _uriBuilder = UriBuilder.fromPath("http://{rest.api.path}");
            _uriBuilder = _uriBuilder.path("/users");
            _templateAndMatrixParameterValues = new HashMap<String, Object>();
            _templateAndMatrixParameterValues.put("rest.api.path", restApiPath);
        }

        /**
         * Create new instance
         * 
         */
        public Users(String restApiPath) {
            this(Client.create(), restApiPath);
        }

        /**
         * Get rest.api.path
         * 
         */
        public String getRestApiPath() {
            return ((String) _templateAndMatrixParameterValues.get("rest.api.path"));
        }

        /**
         * Set rest.api.path
         * 
         */
        public HttpRestApiPath.Users setRestApiPath(String restApiPath) {
            _templateAndMatrixParameterValues.put("rest.api.path", restApiPath);
            return this;
        }

        public static class Uid {

            private Client _client;
            private UriBuilder _uriBuilder;
            private HashMap<String, Object> _templateAndMatrixParameterValues;

            /**
             * Create new instance using existing Client instance
             * 
             */
            public Uid(Client client, String restApiPath, String uid) {
                _client = client;
                _uriBuilder = UriBuilder.fromPath("http://{rest.api.path}");
                _uriBuilder = _uriBuilder.path("/users");
                _uriBuilder = _uriBuilder.path("/{uid}");
                _templateAndMatrixParameterValues = new HashMap<String, Object>();
                _templateAndMatrixParameterValues.put("rest.api.path", restApiPath);
                _templateAndMatrixParameterValues.put("uid", uid);
            }

            /**
             * Create new instance
             * 
             */
            public Uid(String restApiPath, String uid) {
                this(Client.create(), restApiPath, uid);
            }

            /**
             * Get rest.api.path
             * 
             */
            public String getRestApiPath() {
                return ((String) _templateAndMatrixParameterValues.get("rest.api.path"));
            }

            /**
             * Set rest.api.path
             * 
             */
            public HttpRestApiPath.Users.Uid setRestApiPath(String restApiPath) {
                _templateAndMatrixParameterValues.put("rest.api.path", restApiPath);
                return this;
            }

            /**
             * Get uid
             * 
             */
            public String getUid() {
                return ((String) _templateAndMatrixParameterValues.get("uid"));
            }

            /**
             * Set uid
             * 
             */
            public HttpRestApiPath.Users.Uid setUid(String uid) {
                _templateAndMatrixParameterValues.put("uid", uid);
                return this;
            }

            public User getUserAsApplicationJson() {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                return resourceBuilder.method("GET", User.class);
            }

            public<T >T getAsApplicationJson(GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                return resourceBuilder.method("GET", returnType);
            }

            public<T >T getAsApplicationJson(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                return resourceBuilder.method("GET", returnType);
            }

            public User getUserAsApplicationText() {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/text");
                return resourceBuilder.method("GET", User.class);
            }

            public<T >T getAsApplicationText(GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/text");
                return resourceBuilder.method("GET", returnType);
            }

            public<T >T getAsApplicationText(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/text");
                return resourceBuilder.method("GET", returnType);
            }

        }

    }

}
