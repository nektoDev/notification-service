package ru.nektodev.notification.facade;

import com.google.common.base.Strings;
import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nektodev.notification.api.NotificationFacade;
import ru.nektodev.notification.model.exception.IncorrectRequestException;
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
        validateSendMessageRequest(name, message);
        service.sendMessage(name, message);
    }

    private void validateSendMessageRequest(String name, String message) {
        if (Strings.isNullOrEmpty(name)) {
            throw new IncorrectRequestException("Name cannot be null or empty");
        }
        if (Strings.isNullOrEmpty(message)) {
            throw new IncorrectRequestException("Message cannot be null or empty");
        }
    }
}
