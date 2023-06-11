package com.team.hospital.mapper;

import com.team.hospital.entity.SysRolesMenus;
import com.team.hospital.entity.SysRolesMenusExample;
import java.util.List;

public interface SysRolesMenusMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysRolesMenus record);

    int insertSelective(SysRolesMenus record);

    List<SysRolesMenus> selectByExample(SysRolesMenusExample example);

    SysRolesMenus selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysRolesMenus record);

    int updateByPrimaryKey(SysRolesMenus record);
}