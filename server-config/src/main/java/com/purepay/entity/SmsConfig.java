package com.purepay.entity;

import javax.persistence.*;

/**
 * Created by AndreaValenziano on 28/05/18.
 */
@Entity
public class SmsConfig {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String textMessage;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name="provider_id")
    private Provider provider;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTextMessage() {
        return textMessage;
    }

    public void setTextMessage(String textMessage) {
        this.textMessage = textMessage;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }


    @Override
    public String toString() {
        return "SmsConfig{" +
                "id=" + id +
                ", textMessage='" + textMessage + '\'' +
                ", client=" + client +
                ", provider=" + provider +
                '}';
    }
}
