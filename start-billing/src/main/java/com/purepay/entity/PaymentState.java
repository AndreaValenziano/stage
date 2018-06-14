package com.purepay.entity;


import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Created by AndreaValenziano on 31/05/18.
 */
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentState {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 11)
    private int idPaymentState;

    @NotNull
    @Length(max = 200)
    private String paymentStateName;

    @Length(max=500)
    private String paymentStateDescription;

    @Length(max=50)
    private String paymentStateCode;


    @Column(columnDefinition = "DATETIME")
    @CreationTimestamp
    private LocalDateTime insertDate;

    @Column(columnDefinition = "DATETIME")
    @UpdateTimestamp
    private LocalDateTime lastUpdateDate;

    @Column(columnDefinition = "DATETIME")
    private LocalDateTime deleteDate;

    @ColumnDefault(value = "0")
    private boolean isDeleted;

    public PaymentState(String paymentStateName, String paymentStateCode) {
        this.paymentStateName = paymentStateName;
        this.paymentStateCode = paymentStateCode;
    }

    public int getIdPaymentState() {
        return idPaymentState;
    }

    public void setIdPaymentState(int idPaymentState) {
        this.idPaymentState = idPaymentState;
    }

    public String getPaymentStateName() {
        return paymentStateName;
    }

    public void setPaymentStateName(String paymentStateName) {
        this.paymentStateName = paymentStateName;
    }

    public String getPaymentStateDescription() {
        return paymentStateDescription;
    }

    public void setPaymentStateDescription(String paymentStateDescription) {
        this.paymentStateDescription = paymentStateDescription;
    }

    public String getPaymentStateCode() {
        return paymentStateCode;
    }

    public void setPaymentStateCode(String paymentStateCode) {
        this.paymentStateCode = paymentStateCode;
    }

    public LocalDateTime getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(LocalDateTime insertDate) {
        this.insertDate = insertDate;
    }

    public LocalDateTime getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDateTime lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public LocalDateTime getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(LocalDateTime deleteDate) {
        this.deleteDate = deleteDate;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public PaymentState() {
    }

}
