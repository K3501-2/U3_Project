package com.team.hospital.entity;

import java.util.Date;

public class Patient {
    private Long id;

    private String name;

    private Date birthday;

    private Byte sex;

    private String address;

    private String phone;

    private String idCard;

    private Byte isMedicare;

    private String idMedicare;

    private Date createdTime;

    private Date updatedTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public Byte getIsMedicare() {
        return isMedicare;
    }

    public void setIsMedicare(Byte isMedicare) {
        this.isMedicare = isMedicare;
    }

    public String getIdMedicare() {
        return idMedicare;
    }

    public void setIdMedicare(String idMedicare) {
        this.idMedicare = idMedicare == null ? null : idMedicare.trim();
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