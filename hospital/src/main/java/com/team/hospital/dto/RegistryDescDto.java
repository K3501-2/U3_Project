package com.team.hospital.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Author: 林宇扬
 * @Date: 2023/6/18 15:22
 * @Java version: 1.8.0_361
 * @Project Projects
 * @Package com.team.hospital.dto
 * @Classname RegistryDescDto
 * @Created by Administrator
 * @Description:查看挂号详情信息实体类
 */
public class RegistryDescDto {
    private String id;  //挂号id
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date regTime; //病人挂号时间
    private String pname; //病人姓名
    private String paddress; //病人地址
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date pbirthday; //病人生日
    private String psex;  //性别
    private String pcardId;  //身份证
    private String dname;  //科室名称
    private String rname;  //房间名称
    private String userName;  //医生的姓名
    private String pinfo;  //病人的描述
    private String zdinfo;  //诊断结果
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date zdtime;  //诊断时间

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPaddress() {
        return paddress;
    }

    public void setPaddress(String paddress) {
        this.paddress = paddress;
    }

    public Date getPbirthday() {
        return pbirthday;
    }

    public void setPbirthday(Date pbirthday) {
        this.pbirthday = pbirthday;
    }

    public String getPsex() {
        return psex;
    }

    public void setPsex(String psex) {
        this.psex = psex;
    }

    public String getPcardId() {
        return pcardId;
    }

    public void setPcardId(String pcardId) {
        this.pcardId = pcardId;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPinfo() {
        return pinfo;
    }

    public void setPinfo(String pinfo) {
        this.pinfo = pinfo;
    }

    public String getZdinfo() {
        return zdinfo;
    }

    public void setZdinfo(String zdinfo) {
        this.zdinfo = zdinfo;
    }

    public Date getZdtime() {
        return zdtime;
    }

    public void setZdtime(Date zdtime) {
        this.zdtime = zdtime;
    }
}
