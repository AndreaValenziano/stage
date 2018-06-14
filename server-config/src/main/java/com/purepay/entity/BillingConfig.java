package com.purepay.entity;

import javax.persistence.*;

/**
 * Created by AndreaValenziano on 28/05/18.
 */
@Entity
public class BillingConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double maxDailyAmount;
    private double maxMonthlyAmount;
    private double customMaxDailyAmount;
    private double customMaxMonthlyAmount;

    @ManyToOne()
    @JoinColumn(name = "client_id")
    private Client client;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMaxDailyAmount() {
        return maxDailyAmount;
    }

    public void setMaxDailyAmount(double maxDailyAmount) {
        this.maxDailyAmount = maxDailyAmount;
    }

    public double getMaxMonthlyAmount() {
        return maxMonthlyAmount;
    }

    public void setMaxMonthlyAmount(double maxMonthlyAmount) {
        this.maxMonthlyAmount = maxMonthlyAmount;
    }

    public double getCustomMaxDailyAmount() {
        return customMaxDailyAmount;
    }

    public void setCustomMaxDailyAmount(double customMaxDailyAmount) {
        this.customMaxDailyAmount = customMaxDailyAmount;
    }

    public double getCustomMaxMonthlyAmount() {
        return customMaxMonthlyAmount;
    }

    public void setCustomMaxMonthlyAmount(double customMaxMonthlyAmount) {
        this.customMaxMonthlyAmount = customMaxMonthlyAmount;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "BillingConfig{" +
                "id=" + id +
                ", maxDailyAmount=" + maxDailyAmount +
                ", maxMonthlyAmount=" + maxMonthlyAmount +
                ", customMaxDailyAmount=" + customMaxDailyAmount +
                ", customMaxMonthlyAmount=" + customMaxMonthlyAmount +
                ", client=" + client +
                '}';
    }
}

