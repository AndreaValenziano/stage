package com.purepay;

/**
 * Created by AndreaValenziano on 29/05/18.
 */
//@Component
//@ConfigurationProperties("limits")
public class Configuration {

    private double maxDailyAmount;
    private double maxMonthlyAmount;

    public Configuration(double maxDailyAmount, double maxMonthlyAmount) {
        this.maxDailyAmount = maxDailyAmount;
        this.maxMonthlyAmount = maxMonthlyAmount;
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
}
