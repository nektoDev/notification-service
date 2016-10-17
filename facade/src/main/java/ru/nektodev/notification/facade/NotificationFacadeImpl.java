package ru.nektodev.notification.facade;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nektodev.notification.api.NotificationFacade;
import ru.nektodev.notification.service.NotificationService;

/**
 * @author nektodev
 * @date 17/10/2016
 */
@AutoJsonRpcServiceImpl
@Service
public class NotificationFacadeImpl implements NotificationFacade {

    private static final Logger LOG = Logger.getLogger(NotificationFacadeImpl.class);

    @Autowired
    private NotificationService service;

    @Override
    public void sendMessage(String name, String message) {
        service.sendMessage(name, message);
    }
}
