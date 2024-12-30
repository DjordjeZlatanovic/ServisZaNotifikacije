package org.example.restConfiguration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.io.IOException;
import java.util.Collections;

@Configuration
public class UserConfiguration {

    @Bean
    public RestTemplate userRezervacijaRest(){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory("http://localhost:8080"));
//        TokenInterceptor tokenInterceptor = new TokenInterceptor();
//        tokenInterceptor.setToken(token);
//        restTemplate.setInterceptors(Collections.singletonList(tokenInterceptor));
        return restTemplate;
    }
//    private class TokenInterceptor implements ClientHttpRequestInterceptor {
//        private String token;
//
//        public void setToken(String token) {
//            this.token = token;
//        }
//
//        @Override
//        public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes,
//                                            ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
//
//            HttpHeaders headers = httpRequest.getHeaders();
//            headers.add("Authorization", token);
//            return clientHttpRequestExecution.execute(httpRequest, bytes);
//        }
//    }
}
