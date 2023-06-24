package com.team.hospital.service;

import com.github.pagehelper.PageInfo;
import com.team.hospital.dto.MenuDto;
import com.team.hospital.dto.UserDto;
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

    //查询科室和时间段的医生
    public List<SysUsers> getUsersByDepart(Long departmentId, Byte sign);

    //通过科室查寻医生
    public List<UserDto> getUsersByDe(Long departmentId);

    //通过类型查询相关人员 1管理 2挂号 3医生 4，收银员 5.药师
    public List<UserDto> getUsers(Byte type);

    //查询用户的权限菜单
    public List<MenuDto> getUserMenu(Long uid);

    //通过id查询用户信息
    public SysUsers getUserById(Long id);

    //修改用户信息
    public int updateUser(SysUsers record);

    //删除用户信息
    public int deleteUserById(Long id);
}
