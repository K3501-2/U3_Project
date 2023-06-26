package com.team.hospital.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Author: 林宇扬
 * @Date: 2023/6/26 16:42
 * @Java version: 1.8.0_361
 * @Project U3_Project
 * @Package com.team.hospital.dto
 * @Classname ScheduleDto
 * @Created by Administrator
 * @Description:NULL
 */
public class ScheduleDto {
    private Long id;//排期表id

    private String userName;

    private String departmentName;

    private String roomName;

    private Byte sign;

    private Integer quantity;

    private Integer remainingQuantity;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date inquiryTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Byte getSign() {
        return sign;
    }

    public void setSign(Byte sign) {
        this.sign = sign;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getRemainingQuantity() {
        return remainingQuantity;
    }

    public void setRemainingQuantity(Integer remainingQuantity) {
        this.remainingQuantity = remainingQuantity;
    }

    public Date getInquiryTime() {
        return inquiryTime;
    }

    public void setInquiryTime(Date inquiryTime) {
        this.inquiryTime = inquiryTime;
    }
}
