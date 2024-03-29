package com.team.hospital.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.hospital.dto.MenuDto;
import com.team.hospital.dto.UserDto;
import com.team.hospital.entity.SysUsers;
import com.team.hospital.entity.SysUsersExample;
import com.team.hospital.mapper.SysUsersMapper;
import com.team.hospital.service.UserService;
import com.team.hospital.util.MD5Utils;
import com.team.hospital.util.PageParmeter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 林宇扬
 * @Date: 2023/6/9 15:39
 * @Java version: 1.8.0_361
 * @Project Projects
 * @Package com.team.hospital.service.impl
 * @Classname UserServiceImpl
 * @Created by Administrator
 * @Description:用户业务组件实现
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private SysUsersMapper sysUsersMapper;

    //用户登录业务实现
    @Override
    public SysUsers login(String username, String password) {
        //调用dao层
        SysUsersExample example = new SysUsersExample();
        SysUsersExample.Criteria criteria = example.createCriteria();

        //添加条件
        criteria.andAccountEqualTo(username);
        //将密码加密后进行比较
        criteria.andPasswordEqualTo(MD5Utils.md5Encrypt(password));

        List<SysUsers> list = sysUsersMapper.selectByExample(example);
        if (list != null && list.size() == 1)
            return list.get(0);
        else
            return null;
    }

    //获取所有用户
    @Override
    public PageInfo<SysUsers> getUsers(PageParmeter pageParmeter) {
        //1.开启分页
        PageHelper.startPage(pageParmeter.getPage(), pageParmeter.getPageSize());
        //2.查询所有用户
        List<SysUsers> list = this.sysUsersMapper.getAllUser();
        //3.返回分页信息
        return new PageInfo<SysUsers>(list);
    }

    //添加用户
    @Override
    public int addUser(SysUsers user) {
        return sysUsersMapper.insertSelective(user);
    }

    //查询科室和时间段的医生
    @Override
    public List<SysUsers> getUsersByDepart(Long departmentId, Byte sign) {
        return sysUsersMapper.getUsersByDepart(departmentId, sign);
    }

    //通过科室查寻医生
    @Override
    public List<UserDto> getUsersByD(Long departmentId) {
        return sysUsersMapper.getUsersByD(departmentId);
    }

    //通过科室查寻医生
    @Override
    public List<UserDto> getUsersByDe(Long departmentId) {
        return sysUsersMapper.getUsersByDe(departmentId);
    }

    //通过类型查询相关人员 1管理 2挂号 3医生 4，收银员 5.药师
    @Override
    public List<UserDto> getUsers(Byte type) {
        return sysUsersMapper.getUsers(type);
    }

    //查询用户的权限菜单
    @Override
    public List<MenuDto> getUserMenu(Long uid) {
        //1.通过用户的id查询对应的一级菜单
        List<MenuDto> list = this.sysUsersMapper.getMenuByUser(uid);
        //2.循环一级菜单：通过一级菜单的编号找对应的二级菜单
        for (MenuDto menuDto:list){
            //通过一级菜单的编号查询对应的二级菜单
            List<MenuDto> seconMenu = this.sysUsersMapper.getMenuByParentId(menuDto.getId());
            //将二级菜单设置到一级菜单
            menuDto.setChildren(seconMenu);
        }
        return list;
    }

    //获取用户信息
    @Override
    public SysUsers getUserById(Long id) {
        return this.sysUsersMapper.selectByPrimaryKey(id);
    }

    //修改用户信息
    @Override
    public int updateUser(SysUsers record) {
        return this.sysUsersMapper.updateByPrimaryKeySelective(record);
    }

    //删除用户信息
    @Override
    public int deleteUserById(Long id) {
        return this.sysUsersMapper.deleteByPrimaryKey(id);
    }
}
