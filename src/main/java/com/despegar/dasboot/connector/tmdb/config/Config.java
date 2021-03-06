package com.despegar.dasboot.connector.tmdb.config;

import com.despegar.dasboot.connector.interceptor.ContextHeadersInterceptor;
import com.despegar.dasboot.connector.tmdb.ErrorHandler;
import com.despegar.dasboot.connector.interceptor.LoggingInterceptor;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.util.Arrays;

@Component
public class Config {

    @Bean
    @Autowired
    public RestTemplate tmdbClient(TMDBConfig tmdbConfig, ErrorHandler errorHandler) {
        RequestConfig config =
                RequestConfig.custom()
                        .setConnectTimeout(tmdbConfig.getTimeout())
                        .setSocketTimeout(tmdbConfig.getTimeout())
                        .build();
        CloseableHttpClient client = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
        HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(client);
        RestTemplate restTemplate = new RestTemplate(factory);
        restTemplate.setInterceptors(Arrays.asList(new ContextHeadersInterceptor(), new LoggingInterceptor()));
        restTemplate.setErrorHandler(errorHandler);
        restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory(tmdbConfig.getHost()));
        return restTemplate;
    }
}
