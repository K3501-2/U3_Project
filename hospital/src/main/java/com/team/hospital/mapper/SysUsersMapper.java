package com.team.hospital.mapper;

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

    //通过科室和时间段查找医生
    List<UserDto> getUsersByD(long departmentId);
}