package ru.nektodev.notification.api;

import com.googlecode.jsonrpc4j.JsonRpcService;

import java.util.List;

/**
 * @author nektodev
 * @date 17/10/2016
 */
@JsonRpcService("/notification")
public interface NotificationFacade {
    void sendMessage(String name, String message);

    void sendMessage(List<String> names, String message);
}
