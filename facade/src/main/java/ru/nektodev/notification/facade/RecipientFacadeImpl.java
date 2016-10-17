package ru.nektodev.notification.facade;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nektodev.notification.api.RecipientFacade;
import ru.nektodev.notification.model.Recipient;
import ru.nektodev.notification.service.RecipientService;

import java.util.List;

/**
 * @author nektodev
 * @date 17/10/2016
 */
@AutoJsonRpcServiceImpl
@Service
public class RecipientFacadeImpl implements RecipientFacade {

    @Autowired
    private RecipientService service;

    @Override
    public Recipient get(String id) {
        return service.get(id);
    }

    @Override
    public List<Recipient> list() {
        return service.list();
    }

    @Override
    public List<Recipient> save(List<Recipient> recipients) {
        return service.save(recipients);
    }

    @Override
    public void delete(List<String> tList) {
        service.delete(tList);
    }
}
