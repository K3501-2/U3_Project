package com.team.hospital.entity;

import java.math.BigDecimal;
import java.util.Date;

public class PrescriptionDetail {
    private Long id;

    private Long prescriptionId;

    private Long registryId;

    private Long drugId;

    private Long patientId;

    private Integer amount;

    private Byte isMedicare;

    private BigDecimal price;

    private BigDecimal payPrice;

    private BigDecimal medicarePrice;

    private Date createdTime;

    private Date updatedTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(Long prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public Long getRegistryId() {
        return registryId;
    }

    public void setRegistryId(Long registryId) {
        this.registryId = registryId;
    }

    public Long getDrugId() {
        return drugId;
    }

    public void setDrugId(Long drugId) {
        this.drugId = drugId;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Byte getIsMedicare() {
        return isMedicare;
    }

    public void setIsMedicare(Byte isMedicare) {
        this.isMedicare = isMedicare;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPayPrice() {
        return payPrice;
    }

    public void setPayPrice(BigDecimal payPrice) {
        this.payPrice = payPrice;
    }

    public BigDecimal getMedicarePrice() {
        return medicarePrice;
    }

    public void setMedicarePrice(BigDecimal medicarePrice) {
        this.medicarePrice = medicarePrice;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}