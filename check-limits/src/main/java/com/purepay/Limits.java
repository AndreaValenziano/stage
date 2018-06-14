package com.purepay;

/**
 * Created by AndreaValenziano on 22/05/18.
 */
public enum Limits {
    DAY(50.00),MONTH(300.00);

    private double maxAmount;

    Limits(double maxAmount) {
        this.maxAmount = maxAmount;
    }

    public double getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(double maxAmount) {
        this.maxAmount = maxAmount;
    }
}
