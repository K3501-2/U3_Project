package com.team.hospital.dto;

/**
 * @Author: 林宇扬
 * @Date: 2023/6/16 16:38
 * @Java version: 1.8.0_361
 * @Project Projects
 * @Package com.team.hospital.dto
 * @Classname UserDto
 * @Created by Administrator
 * @Description:用户业务查询实体类
 */
public class UserDto {
    private Long id;
    private String userName;

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
}
