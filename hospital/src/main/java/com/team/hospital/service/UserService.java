package com.team.hospital.service;

import com.github.pagehelper.PageInfo;
import com.team.hospital.entity.SysUsers;
import com.team.hospital.util.PageParmeter;


import java.util.List;

/**
 * @Author: 林宇扬
 * @Date: 2023/6/9 15:16
 * @Java version: 1.8.0_361
 * @Project Projects
 * @Package com.team.hospital.service
 * @Classname UserService
 * @Created by Administrator
 * @Description:用户业务组件
 */
public interface UserService {
    //用户登录
    public SysUsers login(String username, String password);

    //获取所有用户
    public PageInfo<SysUsers> getUsers(PageParmeter pageParmeter);

    //添加用户
    public int addUser(SysUsers user);
}
