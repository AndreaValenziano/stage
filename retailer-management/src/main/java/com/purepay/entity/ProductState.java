package com.purepay.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductState {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 11)
    private int idProductState;

    @NotNull
    @Length(max = 200)
    private String productStateName;

    @Length(max = 500)
    private String productStateDescription;
    private String productStateCode;

    @NotNull
    @Column(columnDefinition = "DATETIME")
    @CreationTimestamp
    private LocalDateTime insertDate;

    @UpdateTimestamp
    @Column(columnDefinition = "DATETIME")
    private LocalDateTime lastUpdateDate;

    @Column(columnDefinition = "DATETIME")
    private LocalDateTime deleteDate;

    @ColumnDefault(value = "0")
    private boolean isDeleted;

    public int getIdProductState() {
        return idProductState;
    }

    public void setIdProductState(int idProductState) {
        this.idProductState = idProductState;
    }

    public String getProductStateName() {
        return productStateName;
    }

    public void setProductStateName(String productStateName) {
        this.productStateName = productStateName;
    }

    public String getProductStateDescription() {
        return productStateDescription;
    }

    public void setProductStateDescription(String productStateDescription) {
        this.productStateDescription = productStateDescription;
    }

    public String getProductStateCode() {
        return productStateCode;
    }

    public void setProductStateCode(String productStateCode) {
        this.productStateCode = productStateCode;
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
}
