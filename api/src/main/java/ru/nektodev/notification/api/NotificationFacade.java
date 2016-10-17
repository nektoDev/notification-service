package ru.nektodev.notification.api;

import com.googlecode.jsonrpc4j.JsonRpcService;

/**
 * @author nektodev
 * @date 17/10/2016
 */
@JsonRpcService("/notification")
public interface NotificationFacade {
    void sendMessage(String name, String message);
}
