package ru.nektodev.notification.model;

import com.google.common.base.Objects;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * @author nektodev
 * @date 17/10/2016
 */
public class Recipient implements Serializable {
    @Id
    private String name;
    private String telegramId;

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("name", name)
                .add("telegramId", telegramId)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipient recipient = (Recipient) o;
        return Objects.equal(name, recipient.name) &&
                Objects.equal(telegramId, recipient.telegramId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, telegramId);
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelegramId() {
        return telegramId;
    }

    public void setTelegramId(String telegramId) {
        this.telegramId = telegramId;
    }
}
