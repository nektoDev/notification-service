package ru.nektodev.notification.service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.TelegramBotAdapter;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.nektodev.notification.model.Recipient;

import javax.annotation.PostConstruct;
import java.util.NoSuchElementException;

/**
 * @author nektodev
 * @date 17/10/2016
 */
@Service
public class NotificationService {
    private static final Logger LOG = Logger.getLogger(NotificationService.class);

    @Value("${TG_TOKEN}")
    private String BOT_TOKEN;

    @Autowired
    private RecipientService recipientService;

    private TelegramBot bot;

    @PostConstruct
    public void init() {
        bot = TelegramBotAdapter.build(BOT_TOKEN);
    }

    public void sendMessage(String name, String message) {
        LOG.info("Send message: [" + name + "] " + message);
        Recipient recipient = recipientService.get(name);
        if (recipient == null) {
            throw new NoSuchElementException("User [" + name + "] has't been founded.");
        }
        bot.sendMessage(recipient.getTelegramId(), message);
    }
}
