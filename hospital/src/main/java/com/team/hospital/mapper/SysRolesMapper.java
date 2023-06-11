package com.team.hospital.mapper;

import com.team.hospital.entity.SysRoles;
import com.team.hospital.entity.SysRolesExample;
import java.util.List;

public interface SysRolesMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysRoles record);

    int insertSelective(SysRoles record);

    List<SysRoles> selectByExample(SysRolesExample example);

    SysRoles selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRoles record);

    int updateByPrimaryKey(SysRoles record);
}