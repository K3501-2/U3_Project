package com.team.hospital.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Author: 林宇扬
 * @Date: 2023/6/18 10:43
 * @Java version: 1.8.0_361
 * @Project Projects
 * @Package com.team.hospital.dto
 * @Classname RegistryDto
 * @Created by Administrator
 * @Description:查询挂号信息返回的DTO
 */
public class RegistryDto {
    private Long id;  //持号id
    private String name;  //病人的姓名
    private String sex;  //性别
    private String cardId;  //身份证号
    private String dname;  //科室
    private String sname;  //状态
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;  //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date regTime;  //挂号时间
    private Long pid;  //病人编号
    private String userName;//医生姓名
    private Byte status;//就诊状态

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
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}
