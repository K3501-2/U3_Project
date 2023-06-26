package com.team.hospital.mapper;

import com.team.hospital.dto.MenuDto;
import com.team.hospital.dto.UserDto;
import com.team.hospital.entity.SysUsers;
import com.team.hospital.entity.SysUsersExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUsersMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysUsers record);

    int insertSelective(SysUsers record);

    List<SysUsers> selectByExample(SysUsersExample example);

    SysUsers selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUsers record);

    int updateByPrimaryKey(SysUsers record);

    //获取所有用户信息
    List<SysUsers> getAllUser();

    //通过科室和时间段查找医生 long departmentid, byte sign -->封装类中|集合
    //@Param用于指定mybatis参数名称
    List<SysUsers> getUsersByDepart(
            @Param(value = "departmentId") Long departmentId,
            @Param(value = "sign") Byte sign);

    //通过科室查找医生
    List<UserDto> getUsersByD(Long departmentId);

    //通过科室查找医生
    List<UserDto> getUsersByDe(Long departmentId);

    //通过类型查询相关人员 1管理 2挂号 3医生 4，收银员 5.药师
    List<UserDto> getUsers(Byte type);

    //通过用户编号id查找一级菜单
    List<MenuDto> getMenuByUser(Long uid);

    //通过一级菜单的编号查找对应的二级菜单
    List<MenuDto> getMenuByParentId(Long parentId);

    //通过id查找单条用户信息
    SysUsers getUserById(Long id);
}