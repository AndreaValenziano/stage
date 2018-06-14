package com.purepay.bean;

/**
 * Created by AndreaValenziano on 29/05/18.
 */
public class LimitConfiguration {
    private double maxDailyAmount;
    private double maxMonthlyAmount;

    public LimitConfiguration(double maxDailyAmount, double maxMonthlyAmount) {
        this.maxDailyAmount = maxDailyAmount;
        this.maxMonthlyAmount = maxMonthlyAmount;
    }

    protected LimitConfiguration(){}

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
}
