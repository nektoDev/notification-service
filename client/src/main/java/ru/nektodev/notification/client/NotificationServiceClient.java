package ru.nektodev.notification.client;

import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import com.googlecode.jsonrpc4j.ProxyUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.nektodev.notification.api.NotificationFacade;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * @author nektodev
 * @date 18/10/2016
 */
@Configuration
public class NotificationServiceClient {

    @Bean
    public JsonRpcHttpClient jsonRpcHttpClient(@Value("${notification.service.endpoint}") String endpoint) {
        URL url = null;
        //You can add authentication headers etc to this map
        Map<String, String> map = new HashMap<>();
        try {
            url = new URL(endpoint);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new JsonRpcHttpClient(url, map);
    }

    @Bean
    public NotificationFacade notificationFacade(JsonRpcHttpClient jsonRpcHttpClient) {
        return ProxyUtil.createClientProxy(getClass().getClassLoader(), NotificationFacade.class, jsonRpcHttpClient);
    }
}