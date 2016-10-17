package ru.nektodev.notification.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nektodev.notification.model.Recipient;
import ru.nektodev.notification.repository.RecipientRepository;

import java.util.List;

/**
 * @author nektodev
 * @date 17/10/2016
 */
@Service
public class RecipientService {
    private static final Logger LOG = Logger.getLogger(RecipientService.class);

    @Autowired
    private RecipientRepository repository;

    public Recipient get(String id) {
        return repository.findOne(id);
    }

    public List<Recipient> list() {
        return repository.findAll();
    }

    public List<Recipient> save(List<Recipient> recipients) {
        LOG.info("Save recipients: " + recipients);
        return repository.save(recipients);
    }

    public void delete(List<String> recipientIds) {
        LOG.info("Delete recipients: " + recipientIds);
        for (String recipientId : recipientIds) {
            repository.delete(recipientId);
        }
    }

}
