package com.team.hospital.dto;

/**
 * @Author: 林宇扬
 * @Date: 2023/6/16 10:24
 * @Java version: 1.8.0_361
 * @Project Projects
 * @Package com.team.hospital.dto
 * @Classname RoomDto
 * @Created by Administrator
 * @Description:创建查询房间实体类
 */
//实体类----根据业务创建
public class RoomDto {
    private Integer sid;    //schedule_id
    private Integer id;
    private String name;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
