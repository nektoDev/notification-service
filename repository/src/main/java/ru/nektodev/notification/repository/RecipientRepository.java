package ru.nektodev.notification.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.nektodev.notification.model.Recipient;

/**
 * @author nektodev
 * @date 17/10/2016
 */
public interface RecipientRepository extends MongoRepository<Recipient, String>{
}
