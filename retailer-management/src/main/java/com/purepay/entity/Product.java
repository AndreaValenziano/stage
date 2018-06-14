package com.purepay.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Created by AndreaValenziano on 22/05/18.
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 11)
    private int idProduct;
    @NotNull
    @Length(max = 200)
    private String productName;
    @NotNull
    @Length(max = 500)
    private String productDescription;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idRetailer", referencedColumnName = "idRetailer")
    private Retailer retailer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idProductState", referencedColumnName = "idProductState")
    private ProductState productState;

    @Column(columnDefinition = "LONGTEXT")
    private String note;


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

    private Integer productUniqueCode;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Retailer getRetailer() {
        return retailer;
    }

    public void setRetailer(Retailer retailer) {
        this.retailer = retailer;
    }

    public ProductState getProductState() {
        return productState;
    }

    public void setProductState(ProductState productState) {
        this.productState = productState;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getProductUniqueCode() {
        return productUniqueCode;
    }

    public void setProductUniqueCode(Integer productUniqueCode) {
        this.productUniqueCode = productUniqueCode;
    }

    @Override
    public int hashCode() {
       return Math.abs(new HashCodeBuilder(17,37)
               .append(this.productName.toLowerCase())
               .append(this.retailer.getToken())
               .toHashCode());
    }
}
