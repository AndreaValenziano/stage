package com.purepay.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by AndreaValenziano on 25/05/18.
 */
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Sms {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String msisdn;

    private long code;
    private long receivedCode;
    private String text;

    private LocalDateTime creationTime;
    private LocalDateTime updateTime;
    private LocalDateTime deleteTime;

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public LocalDateTime getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(LocalDateTime deleteTime) {
        this.deleteTime = deleteTime;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public long getReceivedCode() {
        return receivedCode;
    }

    public void setReceivedCode(long receivedCode) {
        this.receivedCode = receivedCode;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Sms{" +
                "id=" + id +
                ", msisdn='" + msisdn + '\'' +
                ", code=" + code +
                ", receivedCode=" + receivedCode +
                ", text='" + text + '\'' +
                ", creationTime=" + creationTime +
                ", updateTime=" + updateTime +
                ", deleteTime=" + deleteTime +
                '}';
    }
}
