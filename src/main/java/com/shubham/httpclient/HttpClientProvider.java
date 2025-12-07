package com.shubham.httpclient;

import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.LoopResources;

public class HttpClientProvider {

    private static final HttpClient CLIENT;

    private HttpClientProvider() {
        throw new UnsupportedOperationException("Utility class");
    }

    static {
        CLIENT = HttpClient.create()
                .runOn(LoopResources.create("MyClient", 4, true))
                .baseUrl("https://jsonplaceholder.typicode.com");
    }

    public static HttpClient getHttpClient() {
        return CLIENT;
    }
}

