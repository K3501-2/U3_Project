package com.team.hospital.mapper;

import com.team.hospital.entity.SysUsersRoles;
import com.team.hospital.entity.SysUsersRolesExample;
import java.util.List;

public interface SysUsersRolesMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysUsersRoles record);

    int insertSelective(SysUsersRoles record);

    List<SysUsersRoles> selectByExample(SysUsersRolesExample example);

    SysUsersRoles selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysUsersRoles record);

    int updateByPrimaryKey(SysUsersRoles record);
}