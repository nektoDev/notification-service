package ru.nektodev.notification.api;

import com.googlecode.jsonrpc4j.JsonRpcService;
import ru.nektodev.notification.model.Recipient;

import java.util.List;

/**
 * @author nektodev
 * @date 17/10/2016
 */
@JsonRpcService("/recipient")
public interface RecipientFacade extends BaseFacade<Recipient> {
    @Override
    Recipient get(String id);

    @Override
    List<Recipient> list();

    @Override
    List<Recipient> save(List<Recipient> recipients);

    @Override
    void delete(List<String> tList);
}
